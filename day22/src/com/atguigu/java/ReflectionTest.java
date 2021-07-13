package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class ReflectionTest {
    // 反射之前，对于person类的操作
    @Test
    public void test1() {
        // 1、创建person类的对象
        Person p1 = new Person("Tom", 12);
        // 2、通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());
    }

    @Test
    public void test2() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        // 1、通过反射创建person类
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person p1 = constructor.newInstance("Tom", 12);
        System.out.println(p1.toString());
        // 2、通过反射，调用对象指定的属性、方法
        Field age = personClass.getDeclaredField("age");
        age.set(p1, 10);
        System.out.println(p1.toString());
        // 3、调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p1);

        System.out.println("********************");

        // 通过反射，可以调用person类的私有结构。比如私有构造器、方法、属性
        // 调用私有的构造器
        Constructor<Person> constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p2 = constructor1.newInstance("Jerry");
        System.out.println(p2);

        // 调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2, "hanmeimei");
        System.out.println(p2);

        // 调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p2, "中国");
        System.out.println(nation);

        // 疑问一：通过直接new的方式或者反射的方式都可以调用公共的结构，开中中到底使用那个
        // 建议：直接new的方法
        // 使用时候使用反射的方式？ 动态创建对象的时候。
        // 反射的特征？
        // 动态性
        // 疑问二：反射机制与面向对象中的封装性是不是矛盾？如何看代两个技术？
        // 不矛盾。

        /*
        * 关于java.lang.Class类的理解：
        *   1、类的加载过程：
        *       程序经过javac.exe命令以后，会生成一个或者多个字节码文件(.class)。
        *       接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
        *       加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行类，此运行
        *       时类，就作为Class的一个实例
        *   2、换句话说，Class的实例就对应一个运行时类。
        *   3、加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取
        *       此运行时类
        *
        * */
    }
    // 获取class的实例的方法
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        // 方式二：通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
        // 方法三：调用Class的静态方法：forName(String classPath)
        Class<?> aClass1 = Class.forName("com.atguigu.java.Person");
        System.out.println(aClass1);

        System.out.println(personClass == aClass);
        System.out.println(personClass == aClass1);

        // 方法四：使用类的加载器：classLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(aClass2);
        System.out.println(aClass2 == aClass1);
    }

    // Class实例可以是那些结构说明：
    @Test
    public void test4() {
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        // 只要元素类型与维度一样就是一个Class
        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();
        System.out.println(c10 == c11);

    }
}
