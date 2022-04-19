package com.chasion.mapper;

import com.chasion.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ParameterMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/17 21:11
 */
public interface ParameterMapper {

    // 查询所有用户
    List<User> getAllUser();

    // 根据用户名查询用户信息
    User getUserByName(String name);

    // 验证登录
    User checkLogin(String username, String password);

    // 验证登录，参数为map
    User checkLoginByMap(Map<String, Object> map);

    // 添加用户信息
    int insertUser(User user);

    // 验证登录，使用@Param
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
