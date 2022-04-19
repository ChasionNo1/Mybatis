package com.chasion.mapper;

import com.chasion.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName CacheMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/19 14:53
 */
public interface CacheMapper {
    /**
     * mybatis的缓存功能:只针对查询有效
     * */
    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
