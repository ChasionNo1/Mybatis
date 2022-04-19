package com.chasion.test;

import com.chasion.mapper.ParameterMapper;
import com.chasion.pojo.User;
import com.chasion.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ParameterMapperTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/17 21:17
 */
public class ParameterMapperTest {

    /*
    - MyBatis获取参数值的两种方式：${}和#{}
    - ${}的本质就是字符串拼接，(sql注入问题，单引号拼接）
      #{}的本质就是占位符赋值
    - ${}使用字符串拼接的方式拼接sql，若为字符串类型或日期类型的字段进行赋值时，
       需要手动加单引号；但是#{}使用占位符赋值的方式拼接sql，此时为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号

       mybatis获取参数值的各种情况：
       1、mapper接口方法的参数为单个的字面量值，可以使用#{param}，可以用任意变量名接收值，什么变量名不重要，接收位不能错
          当使用${param}，需要使用单引号括起来，'${param}'
       2、多个字面量类型的参数：
            若mapper接口中的方法参数为多个时，此时MyBatis会自动将这些参数放在一个map集合中
            以arg0,arg1...为键，以参数为值；
            以param1,param2...为键，以参数为值；
            - 因此只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号。
            - 使用arg或者param都行，要注意的是，arg是从arg0开始的，param是从param1开始的
       3、若mapper接口的方法有多个时，可以手动将这些参数放在一个map中存储
        需要通过\${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号

       4、实体类类型的参数
         可以使用\${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
       5、命名参数
         可以通过@Param注解标识mapper接口中的方法参数，此时，会将这些参数放在map集合中
         map的键[param1,param2,username,password]，两种方式



    * */

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (User u :
                allUser) {
            System.out.println(u);
        }

    }

    @Test
    public void testJDBC() throws Exception {
        // 使用占位符赋值
        String username = "";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement ps = connection.prepareStatement("select * from t_user where id = ?");
        ps.setString(1, "1");
    }

    @Test
    public void testGetUserByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByName("11");
        System.out.println(user);

    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("11", "123");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", "11");
        map.put("password", "123");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User(null, "ccc", "123456", 24, "男", "185897");
        System.out.println(mapper.insertUser(user));
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("11", "123");
        System.out.println(user);
    }
}
