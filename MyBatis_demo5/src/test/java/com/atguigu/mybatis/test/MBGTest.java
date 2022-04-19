package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MBGTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/19 19:16
 */
public class MBGTest {

    @Test
    public void testMBG() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 查询所有数据
//        List<Emp> emps = mapper.selectByExample(null);

        // 根据条件查询
//        EmpExample empExample = new EmpExample();
//        empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
//        empExample.or().andDidIsNotNull();
//        List<Emp> emps = mapper.selectByExample(empExample);
//        System.out.println(emps);
        // 修改
//        int res = mapper.updateByPrimaryKey(new Emp(1, "admin", 22, "男", "5125@qq.com", 2));
        // 如果字段出现null，不会修改
        int res = mapper.updateByPrimaryKeySelective(new Emp(1, "admin", 22, null, "5125@qq.com", 2));
        System.out.println(res);



    }
}
