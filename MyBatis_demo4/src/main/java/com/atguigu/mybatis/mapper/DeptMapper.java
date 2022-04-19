package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import java.util.List;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Tue Apr 19 19:01:57 CST 2022
     */
    int deleteByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Tue Apr 19 19:01:57 CST 2022
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Tue Apr 19 19:01:57 CST 2022
     */
    Dept selectByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Tue Apr 19 19:01:57 CST 2022
     */
    List<Dept> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Tue Apr 19 19:01:57 CST 2022
     */
    int updateByPrimaryKey(Dept record);
}