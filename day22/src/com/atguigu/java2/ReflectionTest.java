package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class ReflectionTest {
    @Test
    public void testFiled() throws Exception {
        Class<Person> personClass = Person.class;
        // 创建运行时类
        Person p1 = personClass.newInstance();
        // 获取指定的属性
        Field id = personClass.getField("id");
        // 设置当前属性的值
        id.set(p1, 1001);
        // 获取当前的属性值
        int idNum = (int) id.get(p1);
        System.out.println(idNum);
    }

    @Test
    public void testFiled2() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Tom");
        String nameShow = (String) name.get(person);
        System.out.println(nameShow);
    }

    @Test
    public void testMethod() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String chine = (String) show.invoke(person, "CHINE");
        System.out.println(chine);

        System.out.println("****************如何调用静态方法********************");

        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
//        Object invoke = showDesc.invoke(Person.class);
//       或者
        Object invoke = showDesc.invoke(null);
        System.out.println(invoke);
    }

    @Test
    public void testConstructor() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person hanMeiMei = declaredConstructor.newInstance("HanMeiMei");
        System.out.println(hanMeiMei);
    }

}
