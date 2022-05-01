package com.example.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xxs
 * @create 2022/5/1 19:40
 */
@Data
public class RpcRequest implements Serializable {

    /**
     * service版本
     */
    private String serviceVersion;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 请求参数
     */
    private Object[] params;

    /**
     * 参数类型
     */
    private Class<?>[] parametersTypes;
}
