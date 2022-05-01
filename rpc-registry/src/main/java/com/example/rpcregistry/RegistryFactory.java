package com.example.rpcregistry;

/**
 * @author xxs
 * @create 2022/5/1 21:44
 */
public class RegistryFactory {

    private static volatile RegistryService registryService;

    public static RegistryService getInstance(String registryAddr, RegistryType type) throws Exception {

        if (null == registryService) {
            synchronized (RegistryFactory.class) {
                if (null == registryService) {
                    switch (type) {
                        case ZOOKEEPER:
                            registryService = new ZookeeperRegistryService(registryAddr);
                            break;
                        case EUREKA:
                            registryService = new EurekaRegistryService(registryAddr);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        System.out.println("registry:" + registryService);
        return registryService;
    }
}
