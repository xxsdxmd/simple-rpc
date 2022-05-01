package com.xxs.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xxs
 * @create 2022/5/1 20:12
 */
@Data
public class RpcProtocol<T> implements Serializable {

    /**
     * 消息处理
     */
    private MsgHandler header;

    /**
     * 内容
     */
    private T body;

}
