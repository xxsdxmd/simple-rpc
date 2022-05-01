package com.example.rpc.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xxs
 * @create 2022/5/1 19:49
 */
@Data
@Component
@ConfigurationProperties(prefix = "rpc")
public class RpcProperties {

    /**
     * 服务端口
     */
    private int servicePort;

    /**
     * 注册中心地址
     */
    private String registerAddr;

    /**
     * 注册中心的类型
     */
    private String registryType;
}
