package com.chasion.mapper;

import com.chasion.pojo.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description MyBatis中的mapper接口相当于以前的dao。但是区别在于，mapper仅仅是接口，我们不需要提供实现类
 * @Author chasion
 * @Date 2022/4/16 15:13
 */
public interface UserMapper {

    /*
    MyBatis面向接口编程的两个一致：
    1、映射文件额namespace要和mapper接口的全类名一致
    2、映射文件中sql语句的id要和mapper接口中的方法名一致

    表---实体类---mapper接口---映射文件 对应一致
    * */
    int insertUser();

    // 修改用户信息
    int updateUser();

    // 删除用户信息
    int deleteUser();

    // 根据id查询用户信息
    User getUserById();

    // 查询所有用户信息
    List<User> getAllUser();
}
