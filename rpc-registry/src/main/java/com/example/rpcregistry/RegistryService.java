package com.example.rpcregistry;

import com.example.rpc.common.ServiceMeta;

import java.io.IOException;

/**
 * @author xxs
 * @create 2022/5/1 21:40
 */
public interface RegistryService {
    /**
     * 注册
     * @param serviceMeta
     * @throws Exception
     */
    void register(ServiceMeta serviceMeta) throws Exception;

    /**
     *
     * @param serviceMeta
     * @throws Exception
     */
    void unRegister(ServiceMeta serviceMeta) throws Exception;

    /**
     * 下线
     * @param serviceName
     * @param invokerHashCode
     * @return
     * @throws Exception
     */
    ServiceMeta discovery(String serviceName, int invokerHashCode) throws Exception;

    /**
     * 消耗
     * @throws IOException
     */
    void destroy() throws IOException;
}
