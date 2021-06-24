package com.atguigu.java;

/*
*   RandomAccessFile的使用：
*       1、RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
*       2、RandomAccessFile既可以作为一个输入流又可以作为一个输出流
*       3、RandomAccessFile作为输出流、写出到文件如果不存在，则在执行过程中自动创建
*          如果已经存在，则会对原有的文件内容进行覆盖(默认情况下，从头覆盖)
* */

import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile r = null;
        RandomAccessFile rw = null;
        try {
            r = new RandomAccessFile(new File("11.jpg"), "r");
            rw = new RandomAccessFile(new File("22.jpg"), "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = r.read(bytes)) != -1) {
                rw.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile(new File("hello.txt"), "rw");
            rw.seek(3); // 将指针调到角标为3的位置
            rw.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile(new File("hello.txt"), "rw");
            // 1、将指针调到3的位置
            rw.seek(3);
            // 2、stringBuild记录指针后面内容
            StringBuilder str = new StringBuilder((int) new File("hello.txt").length());
            byte[] bytes = new byte[20];
            int len;
            while ((len = rw.read(bytes)) != -1) {
                str.append(new String(bytes, 0, len));
            }
            rw.seek(3);
            // 3、将xyz写入内容里
            rw.write("xyz".getBytes());
            // 4、在加保存的内容写文件中
            rw.write(str.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
