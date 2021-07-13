package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        /*
        * newInstance()：调用此方法，创建对应的运行时类的对象。内部调用类运行时类的空参构造
        * 想要此方法正常的创建运行时类的对象，要求：
        *   1、运行时类必须提供空参构造器
        *   2、空参构造器不能时private，通常设置为public
        *
        * 在JavaBean中要求提供一个public的空参构造器的原因：
        *   1、便于反射，创建运行时类的对象
        *   2、便于子类继承此运行时类时，默认调用super()时，父类有此构造器
        * */
        Person person = personClass.newInstance();
        System.out.println(person);
    }

    // 体会反射的动态性
    @Test
    public void test2() {
        int i = new Random().nextInt(3);
        String classPath = "";
        switch (i) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.atguigu.java.Person";
                break;
        }
        Object instance = null;
        try {
            instance = getInstance(classPath);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(instance);
    }

    public Object getInstance(String classPaht) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> aClass = Class.forName(classPaht);
        Object o = aClass.newInstance();
        return o;
    }
}
