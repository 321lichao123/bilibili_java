package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
    lambda表达式的说明：
        1、举例：(o1, o2) -> Integer.compare(o1, o2);
        2、->: lambda操作符 或者 箭头操作符
           ->左边：lambda形参列表(其实就是接口中的抽象方法的形参列表)
           ->右边：lambda体(其实就是重写抽象方法的方法体)
        3、lambda表达式的使用：（分为6中情况）

        4、lambda表达式的本质作为接口的实例
        总结：
            ->左边: lambda表达式形参列表参数类型可以省略(类型推断)，如果lambda表达式的形参列表只有一个参数，其中
                    的()也是可以省略的
            ->右边：lambda体应该使用一堆{}包裹，如果lambda体只有一条执行语句，可以省略大括号也可以省略return
        5、如果一个接口只声明一个抽象方法，则此接口就称为函数式接口

        6、Java内置的4大核心函数式接口：
            消费型接口：Consumer<T>    void accept(T t)
            供给型接口：Supplier<T>    T get()
            函数型接口：Function<T, R> R apply(T t)
            断定型接口：Predicate<T>   boolean test<T t>
 */
public class LambdaTest1 {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去白马会所花费" + aDouble);
            }
        });
        System.out.println("***************************");
        happyTime(1000, money -> System.out.println("学习太累了，去白马会所花费" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "天津", "东京", "西京", "普京");
        List showList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(showList.toString());
        System.out.println("***************************");

        List showList2 = filterString(list, s -> s.contains("京"));
        System.out.println(showList2.toString());
    }

    // 根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
