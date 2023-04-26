package com.czq.dao;

import com.czq.entity.Grade;
import com.czq.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //查询：根据stuno查询
    Student queryStudentByStuNo(int stuNo);

    //查询：根据stuname查询
    Student queryStudentByStuName(String stuName);

    //查询：根据stuname查询（使用HashMap设置输入参数）
    Student queryStudentByStuNameWithHashMap(Map<String , Object> map);

    //查询：根据stuname查询（使用HashMap设置输入参数，模糊查询）
    List<Map<String , Object>> queryStudentLikeStuNameWithHashMap(Map<String , Object> map);

    //查询： if标签的使用
    List<Student> queryStudentByAgeAndName(Student student);

    //查询所有学生
    List<Student> queryAllStudent();

    //查询：使用 属性 传递输入参数  （验证使用foreach标签迭代--属性）
    List<Student> queryStudentByGrade(Grade stuNos);

    //查询：使用 数组 传递输入参数  （验证使用foreach标签迭代--数组）
    List<Student> queryStudentWithArray(int[] stuNos);

    //查询：使用 集合 传递输入参数  （验证使用foreach标签迭代--集合）
    List<Student> queryStudentWithList(List<Integer> stuList);

    //查询：使用 对象数组 传递输入参数  （验证使用foreach标签迭代--对象数组）
    List<Student> queryStudentWithObjectArray(Student[] students);

    //增加学生
    void insertStudent(Student student);

    //根据学号删除
    void deleteStudentByStuNo(int stuNo);

    //根据学号修改
    void updateStudentByStuNo(Student student);

}
