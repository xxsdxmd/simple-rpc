package com.example.rpcregistry;

import com.example.rpc.common.ServiceMeta;

/**
 * @author xxs
 * @create 2022/5/1 21:49
 * 待实现
 */
public class EurekaRegistryService implements RegistryService {

    public EurekaRegistryService(String registryAddr) {
        // TODO
    }

    @Override
    public void register(ServiceMeta serviceMeta) {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int invokerHashCode) {
        return null;
    }

    @Override
    public void destroy() {

    }
}

