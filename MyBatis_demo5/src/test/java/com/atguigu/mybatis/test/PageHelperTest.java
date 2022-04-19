package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PageHelperTest
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/19 19:46
 */
public class PageHelperTest {

    /**
     * limit:index,pageSize
     * index:当前页的起始索引
     * pageSize：每页显示的条数
     * pageNum:当前页的页码
     * index = (pageNum - 1)*pageSize
     * */

    @Test
    public void testPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 实现分页功能，在查询功能之前，开启分页
        PageHelper.startPage(2, 4);
        List<Emp> list = mapper.selectByExample(null);
        // 在查询功能之后获取分页信息，list表示分页数据，5表示当前导航分页的数量
        PageInfo<Emp> page = new PageInfo<>(list, 5);
        System.out.println(page);
//        list.forEach(System.out::println);


    }

    @Test
    public void testList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(System.out::println);
    }
}
