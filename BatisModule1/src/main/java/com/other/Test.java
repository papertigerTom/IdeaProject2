package com.other;

import com.czq.dao.StudentDao;
import com.czq.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSession.openSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> students = mapper.queryAllStudent();
        System.out.println(students);
        session.close();


    }
}
