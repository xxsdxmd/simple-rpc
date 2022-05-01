package com.example.client.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xxs
 * @create 2022/5/1 21:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Autowired
public @interface RpcReference {
    /**
     * 接口版本
     * @return
     */
    String serviceVersion() default "1.0";

    /**
     * 注册中心类型
     * @return
     */
    String registryType() default "ZOOKEEPER";

    /**
     * 注册中心地址
     * @return
     */
    String registryAddress() default "127.0.0.1:2181";

    /**
     * 超时时间
     * @return
     */
    long timeout() default 5000;
}
