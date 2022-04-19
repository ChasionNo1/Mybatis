package com.chasion.mapper;

import com.chasion.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SQLMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 15:08
 */
public interface SQLMapper {

    // 根据用户名模糊查询
    List<User> getUserByLike(@Param("username") String username);

    // 批量删除
    int deleteMore(@Param("ids") String ids);

    // 查询指定表名的内容
    List<User> getUserByTableName(@Param("tableName") String tableName);

    // 添加用户
    void insertUser(User user);
}
