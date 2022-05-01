package com.example.rpc.common;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xxs
 * @create 2022/5/1 19:43
 */
public class RpcRequestHolder {
    /**
     * 请求id生成
     */
    public static final AtomicLong REQUEST_ID_GEN = new AtomicLong(0);

    /**
     * 请求Map
     */
    public static final Map<Long,RpcFuture<RpcResponse>> REQUEST_MAP = new ConcurrentHashMap<>();


}
