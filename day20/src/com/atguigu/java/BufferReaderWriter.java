package com.atguigu.java;

import org.junit.Test;

import java.io.*;

public class BufferReaderWriter {
    @Test
    public void BufferedInputStreamTest() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 1、创建File类
            File file1 = new File("11.jpg");
            File file2 = new File("33.jpg");
            // 2、创建流
            // 2.1 创建节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            // 2.2 创建缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            // 3、复制
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        // 4、关闭流：
        // 要求：先关闭外层，在关闭内存
            if(bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        // 说明：其实关闭外层，Java会帮助我们关闭内存，因此我们可以忽略内层关闭
//        fileInputStream.close();
//        fileOutputStream.close();
        }
    }

    public void copyBufferedFile(String srcPath, String distPath) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file1 = new File(srcPath);
            File file2 = new File(distPath);

            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void copyBufferedFileTest() {
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\12468\\Pictures\\1.mp4";
        String distPath = "C:\\Users\\12468\\Pictures\\3.mp4";
        copyBufferedFile(srcPath, distPath);
        long end = System.currentTimeMillis();
        System.out.println("复制视频花费时间：" + (end - start)); // 1177
    }
}
