package com.atguigu.java;

/*
*   处理流之二：
*       1、转换流：属于字符流
*           InputStreamReader:将一个字节的输入流转为字符流的输入流
*           OutputStreamWriter:将一个字符的输出流转为字节的输出流
*       2、作用：提供字节流与字符流之间的转换
*
*       3、解码：字节、字节数组   -->>> 字符串、字符数组
*          编码：字符串、字符数组 -->>> 字节、字节数组
*
* */

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("aaa.txt");
        // 参数2指明了字符集，具体使用那个字符集，取决于文件aaa.txt保存使用的字符集
//        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); // 默认的
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8"); // 默认的
        char[] chars = new char[1024];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1) {
            String str = new String(chars, 0, len);
            System.out.println(str);
        }
        inputStreamReader.close();
    }

    @Test
    public void test2() throws IOException {

        File file1 = new File("aaa.txt");
        File file2 = new File("bbb.txt");

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");

        char[] chars = new char[20];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1) {
            outputStreamWriter.write(chars, 0, len);
        }

        inputStreamReader.close();
        outputStreamWriter.close();

    }
}
