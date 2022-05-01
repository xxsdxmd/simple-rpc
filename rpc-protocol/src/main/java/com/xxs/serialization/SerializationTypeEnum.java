package com.xxs.serialization;

import lombok.Getter;

/**
 * @author xxs
 * @create 2022/5/1 20:41
 */
public enum SerializationTypeEnum {
    /**
     * hessian
     */
    HESSIAN(0x10),
    /**
     * json
     */
    JSON(0x20);

    @Getter
    private final int type;

    SerializationTypeEnum(int type) {
        this.type = type;
    }

    /**
     * 获取序列化
     * @param serializationType
     * @return
     */
    public static SerializationTypeEnum findByType(byte serializationType) {
        for (SerializationTypeEnum typeEnum : SerializationTypeEnum.values()) {
            if (typeEnum.getType() == serializationType) {
                return typeEnum;
            }
        }
        return HESSIAN;
    }
}