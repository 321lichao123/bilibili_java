package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
* UDP协议的网络编程
* */
public class UDPtest {

    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            String str = "想接收端发送数据";
            byte[] bytes = str.getBytes();
            InetAddress inetAddress = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inetAddress, 3344);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                socket.close();
            }
        }


    }

    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(3344);
            byte[] bytes = new byte[100];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }
}
