package com.xxs.protocol;

import lombok.Getter;

/**
 * @author xxs
 * @create 2022/5/1 20:16
 */
public enum  MsgStatus {

    /**
     * 成功
     */
    SUCCESS(0),

    /**
     * 失败
     */
    FAIL(1);

    @Getter
    private final int code;

    MsgStatus(int code) {
        this.code = code;
    }

}
