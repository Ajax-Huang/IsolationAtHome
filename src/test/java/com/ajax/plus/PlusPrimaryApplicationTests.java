package com.ajax.plus;

import com.ajax.plus.entity.Cust;
import com.ajax.plus.entity.Dept;
import com.ajax.plus.mapper.CustMapper;
import com.ajax.plus.mapper.DeptMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ajax Huang
 * @create 2021-11-01-9:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusPrimaryApplicationTests {
    @Autowired
    private CustMapper custDao;

    @Autowired
    private DeptMapper deptDao;

    @Test
    public void testInsertCust(){
        Cust cust = new Cust("张三", "zhangsan@126.com", 21);
        Cust cust1 = new Cust("张三", "zhangsan@126.com", 22);
        int rows = custDao.insert(cust);
        int row = custDao.insert(cust1);
        System.out.println("插入行数："+rows);
        System.out.println("插入行数："+row);
    }

    @Test
    public void testUpdate(){
        Cust cust = new Cust("zs", "zs@126.com", 21);
        cust.setId(1);
        int rows = custDao.updateById(cust);
        System.out.println("更新影响行数："+rows);
    }

    @Test
    public void testDelete(){
        int rows = custDao.deleteById(1);
        System.out.println("删除影响行数:"+rows);
    }

    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> param = new HashMap<>();
        param.put("age",21);
        param.put("name","张三");
        int rows = custDao.deleteByMap(param);
        System.out.println("删除影响行数:"+rows);
    }

    @Test
    public void testDeleteBatchIds(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        int i = custDao.deleteBatchIds(list);
        System.out.println("删除影响行数："+i);
    }

    @Test
    public void testSelectById(){
        Cust cust = custDao.selectById(5);
        System.out.println(cust);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String, Object> param = new HashMap<>();
        param.put("age",21);
//        param.put("id",6);
        List<Cust> custs = custDao.selectByMap(param);
        System.out.println("查询到的人数:"+custs.size());
    }

    @Test//根据查询构造器进行查询，AllEq等价于map相等条件
    public void testAllEq(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        HashMap<String, Object> tj = new HashMap<>();
        tj.put("name","大黄");
        tj.put("age",null);
        System.out.println(qw.allEq(tj,true));
        List<Cust> custs = custDao.selectList(qw);
        System.out.println(custs);
    }

    @Test
    public void testEq(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();

        qw.eq("name","张三");

        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testNe(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();

        System.out.println(qw.ne("name", "张三"));

        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testGt(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();

        qw.gt("age",21);

        System.out.println(custDao.selectList(qw));

        QueryWrapper<Cust> qw1 = new QueryWrapper<>();
        qw1.ge("age",21);

        System.out.println(custDao.selectList(qw1));

        QueryWrapper<Cust> qw2 = new QueryWrapper<>();
        qw2.between("age",21,22);
        System.out.println(custDao.selectList(qw2));

        QueryWrapper<Cust> qw3 = new QueryWrapper<>();
        qw3.like("name","大");
        System.out.println(custDao.selectList(qw3));

        QueryWrapper<Cust> qw4 = new QueryWrapper<>();
        qw4.isNull("email");
        System.out.println(custDao.selectList(qw4));
    }

    @Test
    public void testIn(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.in("age",0,21,22);
        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testInsql(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.inSql("age","select age from cust where id = 8");
        System.out.println(custDao.selectList(qw));
    }


    @Test
    public void testGroupBy(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.select("name,count(*) personNums");
        qw.groupBy("name");
        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testOrderBy(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.orderByAsc("name");
        qw.orderByDesc("age");
        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testOr(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.like("name","大")
                .or()
                .gt("age",12);
        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testLast(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.eq("age",21)
                .or()
                .like("name","大")
                .last("limit 2");
        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testExists(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.exists("select id from cust where age > 20");
        System.out.println(custDao.selectList(qw));
    }

    @Test
    public void testPage(){
        QueryWrapper<Cust> qw = new QueryWrapper<>();
        qw.orderByDesc("id");

        Page<Cust> page = new Page<>();
        page.setCurrent(1);
        page.setSize(2);

        IPage<Cust> res = custDao.selectPage(page, qw);

        List<Cust> custs = res.getRecords();
        System.out.println(custs);

        System.out.println("总页数:"+res.getPages());
        System.out.println("总记录数:"+res.getTotal());
        System.out.println("当前页码:"+res.getCurrent());
        System.out.println("每页大小:"+res.getSize());

    }

    @Test
    public void testARInsert(){
        Dept dept = new Dept();
        dept.setName("销售部");
        dept.setMobile("95525");
        dept.setManager(1);
        boolean result = dept.insert();
        System.out.println("AR插入："+result);
    }

    @Test
    public void testARUpdate(){
        Dept dept = new Dept();
        dept.setId(3);
        dept.setName("市场部");
        dept.setManager(2);
        boolean res = dept.updateById();
        System.out.println("AR Update:"+res);
    }

    @Test
    public void testARDelete(){
        Dept dept = new Dept();
        boolean res = dept.deleteById(1);
        System.out.println("删除条数："+res);
    }

    @Test
    public void testARSelect(){
        Dept dept = new Dept();
//        dept.setId(2);
        Dept dept1 = dept.selectById(2);
        System.out.println(dept1);
    }

    @Test
    public void testSelectByName(){

        List<Dept> depts = deptDao.selectByName("销售部");

//        System.out.println(depts);
        depts.forEach(System.out::println);
    }
}
