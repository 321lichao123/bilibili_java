package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;

        // 获取属性结构
        // getFields(): 获取当前运行时类及其父类中声明的public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("******************");
        // getDeclaredFields():获取当前运行时类的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    // 权限修饰符 数据类型 变量名
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field f : fields) {
            // 1、权限修饰符
            int modifiers = f.getModifiers();
//            System.out.println(modifiers);
            System.out.print(modifiers + "-->>" + Modifier.toString(modifiers) + "\t");
            // 2、数据类型
            Class<?> type = f.getType();
            System.out.print(type + "\t");
            // 3、变量名
            String fName = f.getName();
            System.out.print(fName);
            System.out.println();
        }
    }
}
