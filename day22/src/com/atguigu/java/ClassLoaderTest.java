package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // 调用系统加载器的getParent()：获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        // 调用扩展类加载器的getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载Java的核心类库，无法加载自定义类的
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        // 读取配置文件的方式一：
        // 此时的默认在当前module下
        // FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        // properties.load(fileInputStream);
        // 读取配置文件的方式二：
        // 此时的默认路径是当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(resourceAsStream);


        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user=" + user + ",password=" + password);
    }
}
