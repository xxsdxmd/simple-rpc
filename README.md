# simple-rpc

> ​	simple-rpc是一个简单的分布式rpc框架。网络传输基于Neety并且实现多种序列化协议和负载均衡算法。



## 1.架构

https://github.com/xxsdxmd/simple-rpc/blob/main/img/rpc.png?raw=true


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