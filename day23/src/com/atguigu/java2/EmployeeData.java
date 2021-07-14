package com.atguigu.java2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "马化腾", 34, 6000.23));
        list.add(new Employee(1002, "马云", 23, 8000.23));
        list.add(new Employee(1003, "刘强东", 45, 9000.32));
        list.add(new Employee(1004, "雷军", 25, 10000.12));
        list.add(new Employee(1005, "李彦斌", 31, 3445.45));
        list.add(new Employee(1006, "比尔盖茨", 24, 5784.56));
        list.add(new Employee(1007, "任正非", 35, 8753.45));
        list.add(new Employee(1008, "扎克伯格", 47, 9853.45));
        return list;
    }
}
