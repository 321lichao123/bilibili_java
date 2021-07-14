package com.atguigu.java4;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test1() {
        Girl girl = new Girl();
        // Optional.of(t)：创建一个Optional实例，t必填，必须为非空
//        girl = null;// 报错
        Optional<Girl> optionalGirl = Optional.of(girl);

    }

    // Optional.empty():创建一个空Optional实例
    @Test
    public void test2() {
        Girl girl = new Girl();
        // Optional.ofNullable(t)：创建一个Optional实例，t可以为null
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    public String getGirlName1(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("苍进空")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("小泽玛利亚"));
        return girl1.getName();
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

}
