package com.xxs.codec;

import com.xxs.protocol.MsgHandler;
import com.xxs.protocol.RpcProtocol;
import com.xxs.serialization.RpcSerialization;
import com.xxs.serialization.SerializationFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author xxs
 * @create 2022/5/1 20:48
 */
public class RpcEncoder extends MessageToByteEncoder<RpcProtocol<Object>> {

    /**
     +---------------------------------------------------------------+
     | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
     +---------------------------------------------------------------+
     | 状态 1byte |        消息 ID 8byte     |      数据长度 4byte     |
     +---------------------------------------------------------------+
     |                   数据内容 （长度不定）                          |
     +---------------------------------------------------------------+
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, RpcProtocol<Object> msg , ByteBuf byteBuf) throws Exception {
        MsgHandler header = msg.getHeader();
        byteBuf.writeShort(header.getMagic());
        byteBuf.writeByte(header.getVersion());
        byteBuf.writeByte(header.getSerialization());
        byteBuf.writeByte(header.getMsgType());
        byteBuf.writeByte(header.getStatus());
        byteBuf.writeLong(header.getRequestId());
        RpcSerialization rpcSerialization = SerializationFactory.getRpcSerialization(header.getSerialization());
        byte[] data = rpcSerialization.serialize(msg.getBody());
        byteBuf.writeInt(data.length);
        byteBuf.writeBytes(data);
    }
}
