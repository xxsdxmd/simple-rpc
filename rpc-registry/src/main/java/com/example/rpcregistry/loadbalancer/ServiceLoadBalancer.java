package com.example.rpcregistry.loadbalancer;

import java.util.List;

/**
 * @author xxs
 * @create 2022/5/1 21:47
 */
public interface ServiceLoadBalancer<T> {
    /**
     * select
     * @param servers
     * @param hashCode
     * @return
     */
    T select(List<T> servers, int hashCode);
}
