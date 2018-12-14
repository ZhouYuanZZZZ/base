package com.zy.spring.test;

import com.alibaba.fastjson.JSON;
import com.zy.spring.App;
import com.zy.spring.entity.Employees;
import com.zy.spring.mapper.EmployeesMapper;
import com.zy.spring.utils.TransactionUtils;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestSpring {

    private Logger logger = LoggerFactory.getLogger(TestSpring.class);

    @Resource
    private EmployeesMapper employeesMapper;

    @Resource
    private TransactionUtils transactionUtils;

    @Test
    public void testJDBCConnection(){
        List<Employees> employees = employeesMapper.selectAll();
        System.out.println(employees.size());
        System.out.println(employees.get(0));
    }

    @Test
    public void testTransaction(){

        Example example = new Example(Employees.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("employeeId",new BigDecimal(100));

        List<Employees> employees = employeesMapper.selectByExample(example);
        Employees item = employees.get(0);
        System.out.println(JSON.toJSONString(item));

        item.setLastName("zzzzzz");
        employeesMapper.updateByPrimaryKeySelective(item);

        TransactionStatus status = transactionUtils.begin();

        try {
            Example example1 = new Example(Employees.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("employeeId",new BigDecimal(101));
            List<Employees> employees1 = employeesMapper.selectByExample(example1);
            Employees item1 = employees1.get(0);
            System.out.println(JSON.toJSONString(item1));

            item1.setLastName("zzzzzz");
            employeesMapper.updateByPrimaryKeySelective(item1);

            Example example2 = new Example(Employees.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("employeeId",new BigDecimal(102));
            List<Employees> employees2 = employeesMapper.selectByExample(example2);
            Employees item2 = employees2.get(0);
            System.out.println(JSON.toJSONString(item2));

            item2.setLastName("zzzzzz");
            employeesMapper.updateByPrimaryKeySelective(item2);

        }catch (Exception e){
            logger.error("",e);
            transactionUtils.rollback(status);
        }

    }
}
