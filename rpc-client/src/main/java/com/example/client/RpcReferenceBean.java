package com.example.client;

import com.example.rpcregistry.RegistryFactory;
import com.example.rpcregistry.RegistryService;
import com.example.rpcregistry.RegistryType;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author xxs
 * @create 2022/5/1 21:39
 */

public class RpcReferenceBean implements FactoryBean<Object> {

    /**
     * 接口名称
     */
    private Class<?> interfaceClass;

    /**
     * service版本
     */
    private String serviceVersion;

    /**
     * 注册中心类型
     */
    private String registryType;

    /**
     * 注册中心地址
     */
    private String registryAddr;

    /**
     * 超时时间
     */
    private long timeout;

    /**
     * 类型
     */
    private Object object;

    @Override
    public Object getObject() throws Exception {
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    /**
     * 初始化
     * @throws Exception
     */
    public void init() throws Exception {
        RegistryService registryService = RegistryFactory.getInstance(this.registryAddr, RegistryType.valueOf(this.registryType));
        this.object = Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new RpcInvokerProxy(serviceVersion, timeout, registryService));
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public void setRegistryType(String registryType) {
        this.registryType = registryType;
    }

    public void setRegistryAddr(String registryAddr) {
        this.registryAddr = registryAddr;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}

