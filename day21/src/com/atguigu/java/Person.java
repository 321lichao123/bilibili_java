package com.atguigu.java;

/*
*  Person需要满足如下的要求，方可序列化
*   1、需要实现接口Serializable
*   2、当前类提供一个全局常量：serialVersionUID
*   3、除了当前Person类需要实现Serializable接口外，还需要保证其内部所有属性也必须是可序列化的(默认情况下，基本数据类型也是可序列化的)
*   补充：
*       ObjectOutputStream和ObjectInputStream都是不能序列化static、transient修饰的成员变量
* */

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 4456837282L;

    private String name;
    private int age;
    private Account act;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account act) {
        this.name = name;
        this.age = age;
        this.act = act;
    }

    public Account getAct() {
        return act;
    }

    public void setAct(Account act) {
        this.act = act;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", act=" + act +
                '}';
    }
}

class Account implements Serializable {

    private static final long serialVersionUID = 445683728245L;

    private double act;

    public double getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public Account(int act) {
        this.act = act;
    }

    @Override
    public String toString() {
        return "Account{" +
                "act=" + act +
                '}';
    }
}
