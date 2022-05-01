package com.example.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xxs
 * @create 2022/5/1 19:45
 */
@Data
public class RpcResponse implements Serializable {

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 响应的msg
     */
    private String msg;


}
