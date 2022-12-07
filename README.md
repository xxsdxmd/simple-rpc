# simple-rpc

> ​	simple-rpc是一个简单的分布式rpc框架。网络传输基于Neety并且实现多种序列化协议和负载均衡算法。



## 1.架构

![Image](https://camo.githubusercontent.com/e11a2ff9575abc290657ba3fdbff5d36f1594e7add67a72e0eda32e449508eef/68747470733a2f2f647562626f2e6170616368652e6f72672f696d67732f6172636869746563747572652e706e67)

## 2.模块

* rpc-server 提供rpc服务 接收处理rpc请求
* rpc-client 服务消费者 使用动态代理发起rpc远程调用
* rpc-registry 注册中心  服务发现 复杂均衡等功能
* rpc-protocol 网络通信 包括 编解码 序列化
* rpc-core 核心类库 定义通用工具类和元数据等信息
* rpc-facade rpc服务接口 对外暴露



## 3.调试

* 启动server
* 启动client
* 启动zk
