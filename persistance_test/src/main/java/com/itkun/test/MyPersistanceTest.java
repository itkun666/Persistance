package com.itkun.test;

import com.itkun.io.Resources;
import com.itkun.sqlsession.SqlSessionFactory;
import com.itkun.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MyPersistanceTest {
    @Test
    public void test() {
        InputStream resouceAsStream = Resources.getResouceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resouceAsStream);


    }
}

