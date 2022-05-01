package com.example.rpc.common;

import lombok.Data;

/**
 * @author xxs
 * @create 2022/5/1 19:59
 */
@Data
public class ServiceMeta {

    /**
     * 服务的名称
     */
    private String serviceName;

    /**
     * 服务的地址
     */
    private String serviceAddr;

    /**
     * 服务的版本
     */
    private String serviceVersion;

    /**
     * 服务的端口
     */
    private int port;
}
