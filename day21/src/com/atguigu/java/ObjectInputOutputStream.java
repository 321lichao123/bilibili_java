package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
*   1、ObjectInputStream和ObjectOutputStream
*   2、作用：用于存储和读取基本数据类型或者对象的处理流，他的强大之处就是可以把Java中对象写入到数据源中
*           也能把对象从数据源还远出来
*
* */
public class ObjectInputOutputStream {

    /*
    * 序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去，使用ObjectOutputStream实现
    * */
    @Test
    public void ObjectOutputStreamTest() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new String("天天学习Java"));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("李超", 18));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("张三", 30, new Account(2300)));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 反序列化：将磁盘文件中的对象还原为内存中的一个Java对象
    * 使用ObjectInputStream实现
    * */
    @Test
    public void objectInputStreamTest() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object readObject = objectInputStream.readObject();
            String str = (String) readObject;
            System.out.println(str);

            Object readObject1 = objectInputStream.readObject();
            Person p = (Person) readObject1;
            System.out.println(p);

            Object readObject2 = objectInputStream.readObject();
            Person p1 = (Person) readObject2;
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
