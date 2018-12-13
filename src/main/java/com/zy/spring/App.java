package com.zy.spring;

import com.alibaba.fastjson.JSON;
import com.zy.spring.entity.Employees;
import com.zy.spring.mapper.EmployeesMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Resource
    private EmployeesMapper employeesMapper;

    @RequestMapping(value = "test0",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test0(){
        List<Employees> employees = employeesMapper.selectAll();
        return JSON.toJSONString(employees);
    }

}
