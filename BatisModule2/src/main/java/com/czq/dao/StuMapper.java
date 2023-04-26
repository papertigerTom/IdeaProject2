package com.czq.dao;

import com.czq.entity.Stu;

import java.util.List;

public interface StuMapper {

    //查询：根据id查询()，返回参数使用resultMap进行设置
    Stu queryStudentByStuNo(int id);

    //查询：根据id查询()，返回参数使用resultType进行设置
    Stu queryStudentByStuNoWithHashMap(int id);

    //查询所有学生
    List<Stu> queryAllStudent();

    //查询学生，根据名字查（具体查询）
    Stu queryStudentByStuName(String name);

    //查询学生，根据名字查(范围查询)
    List<Stu> queryStudentLikeStuName(String name);

    //增加学生
    void insertStudent(Stu student);

    //根据学号删除
    void deleteStudentByStuNo(int id);

    //根据学号修改
    void updateStudentByStuNo(Stu student);



}
