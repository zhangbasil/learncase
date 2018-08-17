package com.zhangbin.learncase.mybaties;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhangbin
 * @Type MybatisLearn
 * @Desc
 * @date 2018-07-24
 * @Version V1.0
 */
public class MybatisLearn {

    public static void main(String[] args) throws IOException {
//        readBean();
        readXml();
    }

    private static void readXml() throws IOException {
        String resource = "mybaties/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        Object obj = sqlSession.selectOne("queryById", 16L);
//        System.out.println("obj = " + obj);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("mapper = " + mapper);
        UserPO userPO = mapper.queryById(19L);
        System.out.println("userPO = " + userPO);
        List<UserPO> list = mapper.query();
        System.out.println("list = " + list);
    }

    private static void readBean() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/archetype?characterEncoding=utf-8");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        configuration.addLoadedResource("mybaties/UserMapper.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("mapper = " + mapper);

        List<UserPO> query = mapper.query();

        System.out.println("query = " + query);

//        UserPO userPO = mapper.queryById(16L);
//        System.out.println("userPO = " + userPO);
//        List<UserPO> query = mapper.query();
//        System.out.println("query = " + query);
    }
}
