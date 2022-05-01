package com.xxs.serialization;

import java.io.IOException;

/**
 * @author xxs
 * @create 2022/5/1 20:29
 */

public interface RpcSerialization {

    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T obj) throws IOException;

    /**
     * 反序列化
     * @param data
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(byte[] data, Class<T> clz) throws IOException;
}
