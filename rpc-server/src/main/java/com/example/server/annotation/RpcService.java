package com.example.server.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xxs
 * @create 2022/5/1 22:13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface RpcService {

    /**
     * 接口
     * @return
     */
    Class<?> serviceInterface() default Object.class;

    /**
     * 版本
     * @return
     */
    String serviceVersion() default "1.0";
}
