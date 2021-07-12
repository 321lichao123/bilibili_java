package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/*
* URL网络编程
*   1、URL：统一资源定位符，对应着互联网的某一个资源地址
*   2、格式：
*       http://localhost:8080/examples/beauty.jpg?usrname=Tom
*       协议    主机名   端口号      资源地址           参数列表
*
* */
public class URLtest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?usrname=Tom");
            System.out.println(url.getProtocol()); // 获取url的协议名
            System.out.println(url.getHost());  // 获取url的主机名
            System.out.println(url.getPort());  // 获取url的端口号
            System.out.println(url.getPath());  // 获取url的路径
            System.out.println(url.getFile()); // 获取url的文件名
            System.out.println(url.getQuery()); // 获取url的差选名
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
