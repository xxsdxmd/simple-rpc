package com.xxs.serialization;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;
import com.sun.xml.internal.ws.encoding.soap.SerializationException;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author xxs
 * @create 2022/5/1 20:33
 */
@Component
public class HessianSerialization implements RpcSerialization {

    /**
     * Hessian序列化
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        if (obj == null) {
            throw  new NullPointerException();
        }
        byte[] res;
        HessianSerializerOutput hessianOutput;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            hessianOutput = new HessianSerializerOutput(os);
            hessianOutput.writeObject(obj);
            hessianOutput.flush();
            res = os.toByteArray();
        } catch (Exception e) {
            throw new SerializationException(e);
        }
        return res;
    }

    /**
     * 反序列化
     * @param data
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> T deserialize(byte[] data, Class<T> clz) throws IOException {
        if (data == null) {
            throw new NullPointerException();
        }
        T result;

        try (ByteArrayInputStream is = new ByteArrayInputStream(data)) {
            HessianSerializerInput hessianInput = new HessianSerializerInput(is);
            result = (T)hessianInput.readObject(clz);
        } catch (Exception e) {
            throw new SerializationException(e);
        }

        return result;
    }
}
