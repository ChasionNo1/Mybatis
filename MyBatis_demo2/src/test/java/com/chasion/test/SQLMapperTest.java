package com.chasion.test;

import com.chasion.mapper.SQLMapper;
import com.chasion.pojo.User;
import com.chasion.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName SQLMapperTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 15:12
 */
public class SQLMapperTest {

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("c");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int res = mapper.deleteMore("1,2,3,4");
        System.out.println(res);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByTableName("t_user");
        System.out.println(userList);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "bbb", "321", 25, "女", "124325@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
