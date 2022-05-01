package com.xxs.serialization;

/**
 * @author xxs
 * @create 2022/5/1 20:40
 */
public class SerializationFactory {

    /**
     * 获取序列化方式
     * @param serializationType
     * @return
     */
    public static RpcSerialization getRpcSerialization(byte serializationType) {
        SerializationTypeEnum typeEnum = SerializationTypeEnum.findByType(serializationType);
        switch (typeEnum) {
            case HESSIAN:
                return new HessianSerialization();
            case JSON:
                return new JsonSerialization();
            default:
                throw new IllegalArgumentException("serialization type is illegal, " + serializationType);
        }
    }
}
