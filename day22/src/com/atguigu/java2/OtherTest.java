package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        // getConstructors():当前运行时类中修饰符为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }

        // getDeclaredConstructors()获取当前运行时类的所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> dc : declaredConstructors) {
            System.out.println(dc);
        }
    }

    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        // 获取运行时类的父类
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        // 获取运行时类带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    public void test4() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType paramter = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramter.getActualTypeArguments();
        System.out.println(actualTypeArguments.toString());
    }

    @Test
    public void test5() {
        Class<Person> personClass = Person.class;
        // 获取运行时类实现的接口
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> a : interfaces) {
            System.out.println(a);
        }

        System.out.println();
        // 获取运行时类的父类的实现接口
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class<?> pf : interfaces1) {
            System.out.println(pf);
        }
    }

    @Test
    public void test6() {
        Class<Person> personClass = Person.class;
        // 获取运行时类所在的包
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void test7() {
        Class<Person> personClass = Person.class;
        // 获取运行时类的注解
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
