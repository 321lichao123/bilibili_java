package com.atguigu.java1;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Comparator;

public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {

            @Override
            public void run() {
                System.out.println("我喜欢吃西瓜");
            }
        };
        r1.run();
        System.out.println("********************");

        Runnable r2 = () -> System.out.println("我喜欢吃桃子");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = comparator.compare(12, 21);
        System.out.println(compare);

        System.out.println("******************************");
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        int compare1 = comparator1.compare(32, 12);
        System.out.println(compare1);

        // 方法引用：
        Comparator<Integer> comparator2 = Integer :: compare;
        int compare2 = comparator1.compare(32, 23);
        System.out.println(compare2);
    }

}
