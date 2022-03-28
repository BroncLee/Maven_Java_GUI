package com.lee.model;

/**
 * com.lee.model
 *
 * @Classname Student
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 星期一 11:02
 */

//javabean 实体类
public class Student {
    private int id;
    private String name;
    private int age;
    private String classes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
