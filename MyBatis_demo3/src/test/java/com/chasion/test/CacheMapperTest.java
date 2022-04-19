package com.chasion.test;

import com.chasion.mapper.CacheMapper;
import com.chasion.pojo.Emp;
import com.chasion.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName CacheMapperTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/19 15:03
 */
public class CacheMapperTest {

    @Test
    public void testCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(1);
        // 增删改会导致一级缓存失效
        mapper.insertEmp(new Emp(null, "dd", 21, "男", "hjasd", null));
        System.out.println(empByEid);
        Emp empByEid1 = mapper.getEmpByEid(1);
        System.out.println(empByEid1);
    }

    /**
     * 测试二级缓存
     * 1. 在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     * 2. 在映射文件中设置标签<cache />
     * 3. 二级缓存必须在SqlSession关闭或提交之后有效
     * 4. 查询的数据所转换的实体类类型必须实现序列化的接口
     * */
    @Test
    public void testCacheTwo(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp empByEid = mapper1.getEmpByEid(1);
        System.out.println(empByEid);
        // sqlsession不关闭，一级缓存生效，二级不生效
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(mapper2.getEmpByEid(1));
        sqlSession2.close();


    }
}
