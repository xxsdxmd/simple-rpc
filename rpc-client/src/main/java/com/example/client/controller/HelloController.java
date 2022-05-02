package com.example.client.controller;

import com.example.client.annotation.RpcReference;
import com.example.rpcfacade.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xxs
 * @create 2022/5/1 21:23
 */
@RestController
public class HelloController {


    @RpcReference(serviceVersion = "1.0.0", timeout = 3000)
    @Resource
    private Hello hello;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return hello.hello("xxs");
    }
}
