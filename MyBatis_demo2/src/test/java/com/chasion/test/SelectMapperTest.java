package com.chasion.test;

import com.chasion.mapper.SelectMapper;
import com.chasion.pojo.User;
import com.chasion.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SelectMapperTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 10:39
 */
public class SelectMapperTest {
    /*
    * Mybatis的各种查询功能：
    * 1、若查询出的数据只有一条，可以通过实体类对象或者集合(list,map)接收
    * 2、若查询出的数据有多条，可以通过实体类型list集合接收或者map类型的list集合接收，
    *   也可以使用@MapKey注解，设置某个查询属性为map的键，其他属性作为map的值
    * {4={password=123, sex=女, id=4, age=23, email=185897780@qq.com, username=11}, ...
     *   一定不能通过实体类对象接收，会抛出异常，
    *
    * MyBatis中设置了默认的类别名：
    * java.lang.Integer --->int,Integer
    * int --> _int, _integer
    * Map --> map
    * String --> string
    *
    *
    * */

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(4);
        System.out.println(user);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer res = mapper.getCount();
        System.out.println(res);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(4);
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }

    @Test
    public void testGetAllUserByMapKey(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserByMapKey();
        System.out.println(map);
    }
}
