package com.example.server.impl;

import com.example.rpcfacade.Hello;
import com.example.server.annotation.RpcService;

/**
 * @author xxs
 * @create 2022/5/1 22:16
 */
@RpcService(serviceInterface = Hello.class, serviceVersion = "1.0.0")
public class HelloImpl implements Hello {

    @Override
    public String hello(String name) {
        return "hello: " + name;
    }
}
