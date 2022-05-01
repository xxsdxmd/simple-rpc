package com.example.rpc.common;

import io.netty.util.concurrent.Promise;
import lombok.Data;

/**
 * @author xxs
 * @create 2022/5/1 19:37
 */
@Data
public class RpcFuture<T> {

    private Promise<T> promise;
    private long timeout;
    public RpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }

}
