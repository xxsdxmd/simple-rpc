package com.example.server;

import com.example.rpc.common.RpcProperties;
import com.example.rpcregistry.RegistryFactory;
import com.example.rpcregistry.RegistryService;
import com.example.rpcregistry.RegistryType;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author xxs
 * @create 2022/5/1 22:19
 */
@Configuration
@EnableConfigurationProperties(RpcProperties.class)
public class RpcServerAutoConfiguration {

    @Resource
    private RpcProperties rpcProperties;

    /**
     * 初始化
     * @return
     * @throws Exception
     */
    @Bean
    public RpcServer init() throws Exception {
        RegistryType type = RegistryType.valueOf(rpcProperties.getRegistryType());
        RegistryService serviceRegistry = RegistryFactory.getInstance(rpcProperties.getRegisterAddr(), type);
        return new RpcServer(rpcProperties.getServicePort(), serviceRegistry);
    }
}
