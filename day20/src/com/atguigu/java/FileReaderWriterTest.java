package com.atguigu.java;

/*
 *   一、流的分类：
 *       1、操作数据单位：字节流、字符流
 *       2、数据的流向：输入流、输出流
 *       3、流的角色：节点流、处理流
 *   二、；流的体系结构：
 *       抽象基类                节点流(或文件流)       缓冲流（处理流的一种）
 *       InputStream             FileInputStream     BufferedInputStream
 *       OutputStream            FileOutputStream    BufferedOutputStream
 *       Reader                  FileReader          BufferedReader
 *       Writer                  FileWriter          BufferedWriter
 *
 *
 * */

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

    /*
    *   1、异常处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    *   2、读入的文件一定要存在，否则就会报FileNotFoundException
    * */
    @Test
    public void FileReaderTest() {
        FileReader reader = null;
        try {
            // 1、实例化File类对象，指明要操作的文件
            File file = new File("hello.txt");  // 这个路径相当于当前的module
            // 2、提供具体的流
            reader = new FileReader(file);
            // 3、数据读取
            // read()返回读入的一个字符。如果到文件末尾返回-1
            int data;
            while((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 4、关闭流
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FileReaderTest1() {
        FileReader reader = null;
        try {
            // 1、文件读取
            File file = new File("hello.txt");
            // 2、提供具体的流
            reader = new FileReader(file);
            // 3、重写read()
            char[] charBuffer = new char[5];
            int len;
            while((len = reader.read(charBuffer)) != -1) {
                // 错误写法一：
//                for (int i = 0; i < charBuffer.length; i++) {
//                    System.out.print(charBuffer[i]); // helloworld123ld
//                }
                // 正确写法一：
//                for (int i = 0; i < len; i++) {
//                    System.out.print(charBuffer[i]);
//                }
                // 错误写法二：错误的原因同一一
//                String str = new String(charBuffer);
//                System.out.print(str);
                // 正确写法二：
                String str = new String(charBuffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                // 4、关闭流
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    *   说明：
    *       1、输出操作，对应的File可以不存在，并不会报异常
    *       2、File对应的硬盘中文件如果不存在，在输出的过程中，会自动创建此文件
    *          File对应的硬盘中的文件如果存在：
    *               如果流使用的构造器是FileWriter(file, false)/FileWriter(file):对原有的文件进行覆盖
    *               如果流使用的构造器是FileWriter(file, true):不会对原有文件覆盖，而是进行追加
    * */
    @Test
    public void FileWriterTest() {
        FileWriter writer = null;
        try {
            // 1、提供File类对象，指明写出的文件
            File file = new File("hello1.txt");
            // 2、提供FileWriter的对象，用于数据的写出
            writer = new FileWriter(file);
            // 3、写出的操作
            writer.write("I have a dream!\n");
            writer.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭流
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FileReaderWriterTest() {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            // 1、创建File类对象，指明读入和写出文件
            File srcFile = new File("hello.txt");
            File distFile = new File("hello2.txt");
            // 2、创建输入流和输出流
            reader = new FileReader(srcFile);
            writer = new FileWriter(distFile);
            // 3、数据的读入和写出操作
            char[] charBuffer = new char[5];
            int len;
            while ((len = reader.read(charBuffer)) != -1) {
                writer.write(charBuffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭流操作
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /*
    *   结论：
    *   1、对于文本文件(.txt、.java、.C),使用字符流处理
    *   2、对于非文本文件(.jpg、.mp3、...)，使用字节流处理
    *
    *
    * */

    @Test
    public void FileInputStreamTest() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 1、创建File类对象，指明读入和写出文件
            File srcFile = new File("11.jpg");
            File distFile = new File("22.jpg");
            // 2、创建输入流和输出流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(distFile);
            // 3、数据的读入和写出操作
            byte[] buffers = new byte[5];
            int len;
            while((len = fileInputStream.read(buffers)) != -1) {
                fileOutputStream.write(buffers, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null ) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copyFile(String srcPath, String distPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 1、创建File类，读取和写入文件
            File file1 = new File(srcPath);
            File file2 = new File(distPath);
            // 2、创建输入流和输出流
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            // 3、读取文件流并输出文件流
            byte[] bytes = new byte[1024];
            int len;
            while ((len = (fileInputStream.read(bytes))) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void copyFileTest() {
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\12468\\Pictures\\1.mp4";
        String distPath = "C:\\Users\\12468\\Pictures\\2.mp4";
        copyFile(srcPath, distPath);
        long end = System.currentTimeMillis();
        System.out.println("复制视频花费的时间：" + (end - start)); // 1447
    }
}
