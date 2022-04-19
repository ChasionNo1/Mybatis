package com.chasion.mapper;

import com.chasion.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SelectMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 10:37
 */
public interface SelectMapper {

    // 根据id查询用户信息
    User getUserById(@Param("id") Integer id);

    // 查询所有用户信息
    List<User> getAllUser();

    // 查询用户信息总记录数
    Integer getCount();

    // 根据id查询用户信息为一个map集合
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    // 查询所有用户信息为map集合
    List<Map<String, Object>> getAllUserToMap();

    // 查询所有用户信息，使用MapKey
    @MapKey("id")
    Map<String, Object> getAllUserByMapKey();
}
