package com.czq.entity;

public class Stu {

    private int id;            //学号
    private String name;        //姓名
    private int age;            //年龄
    private String address;    //地址
    private String grade;        //班级：s1、s2、s3

    public Stu() {
    }

    public Stu(int id, String name, int age, String address, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.grade = grade;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + age + "-" + address + "-" + grade;
    }
}
