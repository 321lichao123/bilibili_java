package com.atguigu.java1;

/*
*   1、网络编程中有两个主要的问题：
*       1、如何准确的定位网络上一台或多台主机，定位主机上的特定的应用
*       2、找到主机后如何可靠高效的进行数据传输
*   2、网络编程中两要素
*       1、对应问题一：IP和端口号
*       2、对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理+数据链层 )
*
*   3、通信三要素：  IP和端口号
*       1、IP唯一的标识Internet上计算机
*       2、在Java中使用InterAddress类代表IP
*       3、IP分类：IPv4和IPv6；万维网和局域网
*       4、域名：www.baidu.com
*       5、本地回路地址：127.0.0.1对应着localhost
*       6、如何实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
*           两个常用方法：getHostName() / getHostAddress()
*       7、端口号：正在计算机上面运行的进程
*               要求：不同的进程有不同的端口号
*               范围：被规定为一个16位整数0~65535
*       8、端口号与IP地址的组合得出一个网络套接字：Socket
* */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.10.14");
            System.out.println(byName);
            InetAddress byName1 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName1);
            InetAddress[] byName2 = InetAddress.getAllByName("localhost");
            System.out.println(byName2);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
