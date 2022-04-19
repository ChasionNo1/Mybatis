package com.chasion.test;

import com.chasion.mapper.DeptMapper;
import com.chasion.mapper.EmpMapper;
import com.chasion.pojo.Dept;
import com.chasion.pojo.Emp;
import com.chasion.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName ResultMapTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 20:12
 */
public class ResultMapTest {

    @Test
    public void getAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        System.out.println(allEmp);
    }

    @Test
    public void getEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(2);
        System.out.println(empAndDept);
    }

    @Test
    public void testGetEmpAndDeptBySteps(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDeptByStepOne = mapper.getEmpAndDeptByStepOne(3);
        // 延迟加载，当前我们访问哪些信息，就会在加载哪些信息，没有访问的，不加载
        System.out.println(empAndDeptByStepOne.getEmpName());
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(2);
        System.out.println(deptAndEmp);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmpByStepOne = mapper.getDeptAndEmpByStepOne(2);
        // 分布查询，可以延迟加载
        System.out.println(deptAndEmpByStepOne);
    }
}
