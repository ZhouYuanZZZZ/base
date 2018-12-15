package com.zy.spring.services;

import com.alibaba.fastjson.JSON;
import com.zy.spring.entity.Employees;
import com.zy.spring.mapper.EmployeesMapper;
import com.zy.spring.utils.ExtTransaction;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeesServices {

    @Resource
    private EmployeesMapper employeesMapper;

    @ExtTransaction
    public void testTransaction0(){
        Example example1 = new Example(Employees.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("employeeId", new BigDecimal(101));
        List<Employees> employees1 = employeesMapper.selectByExample(example1);
        Employees item1 = employees1.get(0);
        System.out.println(JSON.toJSONString(item1));

        item1.setLastName("3");
        employeesMapper.updateByPrimaryKeySelective(item1);

        int i = 0;
        i = 3 / i;

        Example example2 = new Example(Employees.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("employeeId", new BigDecimal(102));
        List<Employees> employees2 = employeesMapper.selectByExample(example2);
        Employees item2 = employees2.get(0);
        System.out.println(JSON.toJSONString(item2));

        item2.setLastName("3");
        employeesMapper.updateByPrimaryKeySelective(item2);
    }
}
