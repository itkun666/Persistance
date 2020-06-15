package com.itkun.config;

import com.itkun.pojo.Configuration;
import com.itkun.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlMapperBuilder {
    private Configuration configuration;

    public XmlMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {
        Document read = new SAXReader().read(inputStream);
        //mapper
        Element rootElement = read.getRootElement();
        String namespace = rootElement.attributeValue("namespace");
        List<Element> list = rootElement.selectNodes("//select");
        Map<String, MappedStatement> mappedStatementMap = new HashMap<String, MappedStatement>();
        for (Element element : list) {
            MappedStatement statement = new MappedStatement();
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sql = element.getTextTrim();
            statement.setId(id);
            statement.setResultType(resultType);
            statement.setParamterType(paramterType);
            statement.setSql(sql);
            String statementId = namespace + "." + id;
            configuration.getMappedStatementMap().put(statementId, statement);
        }
    }
}
