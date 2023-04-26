package com.czq.dao;

import com.czq.entity.Grade;
import com.czq.entity.Student;
import com.czq.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;


public class StudentDaoTest {

    @Test
    //查询，根据stuno查询学生
    public void test1() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student = mapper.queryStudentByStuNo(101);
        System.out.println(student);
        session.close();
    }

    @Test
    //根据stuname查询学生
    public void test() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student = mapper.queryStudentByStuName("张三");
        System.out.println(student);
        session.close();
    }

    @Test
    //根据姓名查询学生，
    // mapper.xml中的parameterType使用 HashMap 设置输入参数
    public void test2() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("studentName", "老王");
        Student student = mapper.queryStudentByStuNameWithHashMap(studentMap);
        System.out.println(student);
        session.close();
    }

    @Test
    //根据姓名查询学生（模糊查询）
    // mapper.xml中的parameterType使用 HashMap 设置输入、输出参数
    public void test3() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);

        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("stuname", "老");
        List<Map<String, Object>> students = mapper.queryStudentLikeStuNameWithHashMap(studentMap);

        //使用迭代器遍历查询返回集List
        Iterator<Map<String, Object>> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        session.close();
    }

    @Test
    //根据姓名查询学生，
    // mapper.xml中的——————if标签——————的使用
    public void test4() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setStuName("老王");
        student.setStuAge(24);
//        student.setGraName("S2");
        List<Student> students = mapper.queryStudentByAgeAndName(student);
        System.out.println(students);
        session.close();
    }

    @Test
    //查询所有学生
    public void test5() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> students = mapper.queryAllStudent();
        System.out.println(students);
        session.close();
    }

    //--------------foreach标签----------------
    //使用foreach标签迭代--属性（类中属性为list类型的属性）
    //查询：查询年级中的所有学生     例如106,108
    @Test
    public void test6() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        //年级类grade
        Grade grade = new Grade();
        //给年级类中的list属性赋值
        List<Integer> stuNos = new ArrayList<>();
        stuNos.add(106);
        stuNos.add(108);
        grade.setStuNos(stuNos);
        //调用查询方法：输入参数为Grade类，输出参数为Student类
        List<Student> students = mapper.queryStudentByGrade(grade);

        System.out.println(students);
        session.close();
    }

    //--------------foreach标签----------------
    //使用foreach标签迭代--数组（简单数组，int[]等）
    //查询    例如stuArray[106,108,103]
    @Test
    public void test10() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        int[] stuNos = new int[]{106, 108, 103};
        List<Student> students = mapper.queryStudentWithArray(stuNos);
        System.out.println(students);
        session.close();
    }

    //--------------foreach标签----------------
    //使用foreach标签迭代--集合
    //查询    例如list{106,108,103}
    @Test
    public void test11() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        ArrayList<Integer> stuList = new ArrayList<>();
        stuList.add(103);
        stuList.add(106);
        stuList.add(108);
        List<Student> students = mapper.queryStudentWithList(stuList);
        System.out.println(students);
        session.close();
    }

    //--------------foreach标签----------------
    //使用foreach标签迭代--数组（对象数组，student[]）
    //查询    例如Student[106,108,103]
    @Test
    public void test12() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);

        Student student1 = new Student();
        student1.setStuNo(101);
        Student student2 = new Student();
        student2.setStuNo(102);
        Student student3 = new Student();
        student3.setStuNo(103);
        Student[] studentArray = new Student[]{student1, student2, student3};

        List<Student> students = mapper.queryStudentWithObjectArray(studentArray);
        System.out.println(students);
        session.close();
    }

    @Test
    //增加学生
    public void test7() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        //#{stuNo},#{stuName},#{stuAddress},#{stuAge},#{graName}
        Student student = new Student(105, "lisi", 23, "西安", "s3");
        mapper.insertStudent(student);
        session.commit();
        System.out.println("增加成功！");
        session.close();
    }

    @Test
    //删除（根据学号删除）
    public void test8() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        mapper.deleteStudentByStuNo(105);
        session.commit();
        System.out.println("删除成功！");
        session.close();
    }

    @Test
    //修改（根据学号修改）
    public void test9() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student = new Student(105, "lisi", 25, "武汉", "s1");
        mapper.updateStudentByStuNo(student);
        session.commit();
        System.out.println("修改成功！");
        session.close();
    }

}
