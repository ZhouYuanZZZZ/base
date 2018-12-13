package com.zy.spring.test;

import com.zy.spring.App;
import com.zy.spring.entity.Employees;
import com.zy.spring.mapper.EmployeesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestSpring {

    @Resource
    private EmployeesMapper employeesMapper;

    @Test
    public void testJDBCConnection(){
        List<Employees> employees = employeesMapper.selectAll();
        System.out.println(employees.size());
        System.out.println(employees.get(0));

    }
}
