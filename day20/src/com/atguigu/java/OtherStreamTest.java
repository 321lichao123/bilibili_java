package com.atguigu.java;

/*
*   其他流的使用
*       1、标准的输入、输出流
*       2、打印流
*       3、数据流
*
* */

import org.junit.Test;

import java.io.*;

public class OtherStreamTest {
    /*
    * 1、标准的输入、输出流
    *   1.1
    *       System.in：标准的输入流， 默认从键盘输入
    *       System.out: 标签的输出流，默认从控制台输出
    *   1.2
    *       System类的setIn(InputStream is) / setOut(PrintStream ps)方法重新指定输入和输出内容
    * */

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true) {
                System.out.print("请输入字符串：");
                String data = bufferedReader.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("退出程序");
                    break;
                }

                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 2、打印流
    * */
    @Test
    public void test1() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("D:\\java\\bilibili_java\\day20\\io.txt"));
            PrintStream printStream = new PrintStream(fileOutputStream, false);
            if (printStream != null) {
                System.setOut(printStream);
            }
            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if(i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    *   3、数据流
    *       3.1作用：
    *           为了Java更好的处理基本数据类型和String类型，
    *       3.2 DataInputStream和DataOutputStream
    *
    * */
    @Test
    public void test3() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
            dataOutputStream.writeUTF("李超");
            dataOutputStream.flush();
            dataOutputStream.writeInt(18);
            dataOutputStream.flush();
            dataOutputStream.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("data.txt"));
            String name = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            boolean isMale = dataInputStream.readBoolean();
            System.out.println("name =" + name);
            System.out.println("age =" + age);
            System.out.println("isMale =" + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
