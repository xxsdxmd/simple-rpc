package com.xxs.protocol;

import lombok.Getter;

/**
 * @author xxs
 * @create 2022/5/1 20:19
 */
public enum  MsgType {
    /**
     * 请求
     */
    REQUEST(1),

    /**
     * 响应
     */
    RESPONSE(2),

    /**
     * 心跳
     */
    HEARTBEAT(3);

    @Getter
    private final int type;

    MsgType(int type) {
        this.type = type;
    }

    /**
     * 获取类型
     * @param type
     * @return
     */
    public static MsgType findType(int type) {
         for (MsgType msgType : MsgType.values()) {
             if (msgType.getType() == type) {
                 return msgType;
             }
         }
         return null;
    }
}
