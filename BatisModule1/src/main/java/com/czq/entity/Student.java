package com.czq.entity;

public class Student {
    private int stuNo;            //学号
    private String stuName;        //姓名
    private int stuAge;            //年龄
    private String stuAddress;    //地址
    private String graName;        //班级：s1、s2、s3

    public Student() {
    }

    public Student(int stuNo, String stuName, int stuAge, String stuAddress, String graName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuAddress = stuAddress;
        this.graName = graName;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getGraName() {
        return graName;
    }

    public void setGraName(String graName) {
        this.graName = graName;
    }

    @Override
    public String toString() {
        return stuNo + "-" + stuName + "-" + stuAge + "-" + stuAddress + "-" + graName;
    }
}
