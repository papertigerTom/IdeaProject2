package com.czq.dao;

import com.czq.entity.Stu;
import com.czq.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class StuMapperTest {


    /*
        查询学生，根据学生id查。
        实体类Stu的属性id和student表的字段stuno，对不上
        在mapper.mxl中可以使用resultMap定义返回值
    */
    @Test
    public void test1() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        Stu stu = mapper.queryStudentByStuNo(101);
        System.out.println(stu);
        session.close();
    }

    /*
    查询学生，根据学生id查。
    实体类Stu的属性id和student表的字段stuno，对不上
    在mapper.mxl中可以使用resultType定义返回值，然后将表的列，取别名为实体类Stu对应的属性
    */
    @Test
    public void test2() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        Stu stu = mapper.queryStudentByStuNoWithHashMap(101);
        System.out.println(stu);
        session.close();
    }


    @Test
    //查询所有学生
    public void test3() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        List<Stu> stus = mapper.queryAllStudent();
        Iterator<Stu> iterator = stus.iterator();
        //使用迭代器遍历查询到的所有学生
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        session.close();
    }

    @Test
    //查询学生,根据名字查
    public void test4() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        Stu stus = mapper.queryStudentByStuName("张三");
        System.out.println(stus);
        session.close();
    }

    @Test
    //查询学生,根据名字像什么查（模糊查询）  stuname like %老%
    public void test5() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        List<Stu> students = mapper.queryStudentLikeStuName("老");
        for (Stu student: students) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    //增加学生
    public void test() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        Stu student = new Stu();
        student.setId(108);
        student.setName("老八");
        student.setAge(22);
        student.setAddress("云南");
        student.setGrade("S3");
        mapper.insertStudent(student);
        session.commit();
        System.out.println("增加成功！");
        session.close();
    }


}
