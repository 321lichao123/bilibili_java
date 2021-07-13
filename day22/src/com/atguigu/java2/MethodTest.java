package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;

        //获取所有的方法
        // getMethods(): 获取当前运行时类及其父类中修饰符为public的方法
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        // getDeclaredMethods(): 获取当前运行时类中所有的定义的方法
        Method[] methods1 = personClass.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            // 获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            // 获取方法的权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            // 返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            // 获取方法名
            System.out.print(m.getName() + "\t");

            // 获取形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i == parameterTypes.length - 1) {
                        System.out.println(parameterTypes[i].getName() + "arg_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i] + "arg_" + i + ",");
                }
            }
            System.out.print(")");

            // 获取异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length == 0)) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }
    }
}
