package com.chasion.test;

import com.chasion.mapper.UserMapper;
import com.chasion.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MyBatisTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/16 16:30
 */
public class MyBatisTest {

    @Test
    public void testMyBatis() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取sqlSession，设置自动提交事务，参数为true
        // 获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        // 创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象，底层是代理模型，返回对应接口的实现类的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 测试功能
        int res = mapper.insertUser();
//        // 提交事务
//        sqlSession.commit();
        System.out.println(res);
    }

    @Test
    public void testCURD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper.updateUser());
//        System.out.println(mapper.deleteUser());
//        System.out.println(mapper.getUserById());

        List<User> allUser = mapper.getAllUser();
        for (User u :
                allUser) {
            System.out.println(u);
        }
    }


}
