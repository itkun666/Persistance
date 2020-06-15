package com.itkun.sqlsession;

import com.itkun.config.XmlConfigBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {
   public SqlSessionFactory build(InputStream in) throws Exception {
        // 使用dom4j 解析配置文件，封装到configuration中
        XmlConfigBuilder builder = new XmlConfigBuilder();
        builder.parseConfig(in);
        //创建SqlSessionFactory

        return null;
    }
}
