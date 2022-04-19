package com.chasion.mapper;

import com.chasion.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName EmpMapper
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 19:43
 */
public interface EmpMapper {

    /**
     * 查询所有员工信息
     * */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门
     * */
    Emp getEmpAndDept(@Param("id") Integer id);

    /**
     * 通过分布查询查询员工以及员工所对应的部分信息
     * 分布查询第一步：查询员工信息
     * */
    Emp getEmpAndDeptByStepOne(@Param("id") Integer id);

    /**
     * 通过分布查询查询部门以及部门中所有员工信息
     * 分布查询第二步：根据did查询员工信息
     * */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
