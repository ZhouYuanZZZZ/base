package com.zy.connontest;

import com.zy.spring.ioc.IOCApplicationCpntext;
import com.zy.spring.ioc.testbean.Bean0;
import com.zy.spring.mapper.EmployeesMapper;
import org.junit.Test;

public class Test0 {

    @Test
    public void test0(){
        String name = EmployeesMapper.class.getPackage().getName();
        System.out.println(name);
    }

    @Test
    public void testIoc() throws IllegalAccessException, InstantiationException {
        String packageName = "com.zy.spring.ioc.testbean";

        IOCApplicationCpntext iocApplicationCpntext = new IOCApplicationCpntext(packageName);

        Bean0 bean0 = (Bean0) iocApplicationCpntext.getBean("bean0");

        System.out.println(bean0);
    }
}
