package com.chasion.mapper;

import com.chasion.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName DeptMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 19:43
 */
public interface DeptMapper {

    /**
     * 通过分布查询查询员工以及员工所对应的部分信息
     * 第二步：通过did查询员工所对应的部门信息
     * */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 获取部分以及部门中所有的员工信息
     * */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分布查询查询部门以及部门中所有员工信息
     * 分布查询第一步：查询部门信息
     * */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
