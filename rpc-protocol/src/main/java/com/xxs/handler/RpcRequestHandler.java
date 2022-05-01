package com.xxs.handler;

import com.example.rpc.common.RpcRequest;
import com.example.rpc.common.RpcResponse;
import com.example.rpc.common.RpcServiceHelper;
import com.xxs.protocol.MsgHandler;
import com.xxs.protocol.MsgStatus;
import com.xxs.protocol.MsgType;
import com.xxs.protocol.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.apache.log4j.Logger;
import org.springframework.cglib.reflect.FastClass;

import java.util.Map;

/**
 * @author xxs
 * @create 2022/5/1 20:10
 */

public class RpcRequestHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcRequest>> {

    private static final Logger log = Logger.getLogger(RpcRequestHandler.class);
    /**
     * rpcMap
     */
    private final Map<String, Object> rpcServiceMap;

    /**
     * 构造器
     * @param rpcServiceMap
     */
    public RpcRequestHandler(Map<String, Object> rpcServiceMap) {
        this.rpcServiceMap = rpcServiceMap;
    }

    /**
     * 管道
     * @param ctx
     * @param protocol
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcRequest> protocol) {
        RpcRequestProcessor.submitRequest(() -> {
            RpcProtocol<RpcResponse> resProtocol = new RpcProtocol<>();
            RpcResponse response = new RpcResponse();
            MsgHandler header = protocol.getHeader();
            header.setMsgType((byte) MsgType.RESPONSE.getType());
            try {
                Object result = handle(protocol.getBody());
                response.setData(result);
                header.setStatus((byte) MsgStatus.SUCCESS.getCode());
                resProtocol.setHeader(header);
                resProtocol.setBody(response);
            } catch (Throwable throwable) {
                header.setStatus((byte) MsgStatus.FAIL.getCode());
                response.setMsg(throwable.toString());
                log.error("process request {} error" + header.getRequestId(), throwable);
            }
            ctx.writeAndFlush(resProtocol);
        });
    }

    /**
     * 处理
     * @param request
     * @return
     * @throws Throwable
     */
    private Object handle(RpcRequest request) throws Throwable {
        String serviceKey = RpcServiceHelper.buildServiceKey(request.getClassName(), request.getServiceVersion());
        Object serviceBean = rpcServiceMap.get(serviceKey);

        if (serviceBean == null) {
            throw new RuntimeException(String.format("service not exist: %s:%s", request.getClassName(), request.getMethodName()));
        }

        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParametersTypes();
        Object[] parameters = request.getParams();

        FastClass fastClass = FastClass.create(serviceClass);
        int methodIndex = fastClass.getIndex(methodName, parameterTypes);
        return fastClass.invoke(methodIndex, serviceBean, parameters);
    }
}

