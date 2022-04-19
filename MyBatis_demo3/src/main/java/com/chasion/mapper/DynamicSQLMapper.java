package com.chasion.mapper;

import com.chasion.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DynamicSQLMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/19 10:05
 */
public interface DynamicSQLMapper {

    /**
     * 多条件查询
     * */
    List<Emp> getEmpCondition(Emp emp);

    /**
     * 测试choos、when、otherwise
     * */
    List<Emp> getEmpConditionByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     * */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     * */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
