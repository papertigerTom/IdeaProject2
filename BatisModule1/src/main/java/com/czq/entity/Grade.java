package com.czq.entity;

import java.util.List;

public class Grade {

    private List<Integer> stuNos;   //stuNos：年级中学生的学号的集合，里面存放该年级学生的学号，如 {101,103,...}

    public List<Integer> getStuNos() {
        return stuNos;
    }

    public void setStuNos(List<Integer> stuNos) {
        this.stuNos = stuNos;
    }
}
