package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

interface Human {
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/*
    要实现动态代理，需要解决的问题？
     问题一：如何根据加载到内存中的被代理类，动态创建一个代理类及其对象
     问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory {

    // 调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj) { // obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

// 创建动态
class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用a方法时，就会自动的调用如下的方法：invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method:即为代理类对象调用的方法，此方法也就作为被代理类对象要调用的方法
        // obj:被代理类的对象
        Object invokeValue = method.invoke(obj, args);
        // invokeValue: 即为当前类的invoke()的返回值
        return invokeValue;
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance：代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        proxyInstance.getBelief();
        proxyInstance.eat("西瓜");

        System.out.println("*************************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory nikeProxy = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        nikeProxy.productCloth();
    }
}
