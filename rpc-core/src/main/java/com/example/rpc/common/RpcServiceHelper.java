package com.example.rpc.common;

/**
 * @author xxs
 * @create 2022/5/1 19:58
 */
public class RpcServiceHelper {

    /**
     * 生成服务的key
     * @param serviceName
     * @param serviceVersion
     * @return
     */
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("#",serviceName,serviceVersion);
    }
}
