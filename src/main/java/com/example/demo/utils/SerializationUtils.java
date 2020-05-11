package com.example.demo.utils;

import java.io.*;

public class SerializationUtils {
    /**
     * 序列化对象
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj){
        ObjectOutputStream oos =null;
        ByteArrayOutputStream bos=null;
        try {
            bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            oos.writeObject(obj);
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(bos);
            close(oos);
        }
        return null;
    }

    /**
     * 反序列化获取对象
     * @param bytes
     * @return
     */
    public static Object unSerialize(byte[] bytes) {
        ObjectInputStream ois =null;
        ByteArrayInputStream bis=null;
        try {
            bis =new ByteArrayInputStream(bytes);
            ois=new ObjectInputStream(bis);

            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(bis);
            close(ois);
        }
        return null;
    }

    /**
     * 关闭IO流
     * @param closeable
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
