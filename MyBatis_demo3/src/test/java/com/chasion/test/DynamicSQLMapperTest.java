package com.chasion.test;

import com.chasion.mapper.DynamicSQLMapper;
import com.chasion.pojo.Emp;
import com.chasion.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DynamicSQLMapperTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/19 10:13
 */
public class DynamicSQLMapperTest {
    /**
     * 动态SQL:
     * 1、if：根据标签中test属性所对应的表达式来决定标签的内容，是否需要拼接到SQL中
     * 2、where：当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或者or去掉
     *           当where标签内没有内容时，不生成where标签，内容后面的and或者or不能去掉
     * 3、trim：
     *          prefix|suffix：将trim标签中内容前后或者添加指定内容
     *          prefixOverrides|suffixOverrides：将trim标签中内容前面或后面去掉指定内容
     * 4、choose、when、otherwise，相当于if...else if...else
     *
     * */

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empCondition = mapper.getEmpCondition(new Emp(null, "", 23, "男", "123@qq.com"));
        System.out.println(empCondition);
    }

    @Test
    public void getEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpConditionByChoose(new Emp(null, "张三", 23, "男", "123@qq.com", null));
        System.out.println(emps);
    }

    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int res = mapper.deleteMoreByArray(new Integer[]{6, 7});
        System.out.println(res);
    }

    @Test
    public void testInsertByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "aa", 12, "男", "1234@qq.com");
        Emp emp2 = new Emp(null, "bb", 12, "男", "1234@qq.com");
        Emp emp3 = new Emp(null, "cc", 12, "男", "1234@qq.com");
        ArrayList<Emp> list = new ArrayList<Emp>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        int res = mapper.insertMoreByList(list);
        System.out.println(res);
    }
}
