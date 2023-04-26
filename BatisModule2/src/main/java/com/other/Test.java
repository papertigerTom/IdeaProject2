package com.other;

import com.czq.dao.StuMapper;
import com.czq.entity.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis2-config.xml");
        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSession.openSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        List<Stu> students = mapper.queryAllStudent();
        System.out.println(students);
        session.close();


    }
}
