package com.atguigu.java1;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    // 客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 创建Socket对象，指明服务器服务器端ip和端口号
            InetAddress inet = InetAddress.getByName("192.168.97.97");
            socket = new Socket(inet, 3344);
            // 获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();
            // 写出数据的操作
            outputStream.write("你好，这边客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 服务端
    @Test
    public void serve() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 创建服务端的serveSocket，指定自己的端口号
            serverSocket = new ServerSocket(3344);
            // 调用accept()表示接收来自于客户端的socket
            accept = serverSocket.accept();
            // 获取输入流
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            // 读取数据
            byte[] bytes = new byte[5];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if(byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
