package com.czq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 工具类：MyBatisUtils
 * 作用：通过SqlSessionFactory工厂，创建SqlSession对象
 */

public class MyBatisUtils {

    private static SqlSessionFactory sqlSession = null;

    static {
        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过sqlSessionFactory的openSession()方法获取SqlSession对象
    public static SqlSession getSqlSession() {
        return sqlSession.openSession();
    }

}
