package com.zy.reflect;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class App {

    private Class<DemoClass> demoClazz;

    @Before
    public void before(){
        demoClazz = DemoClass.class;
    }

    @Test
    public void testGetDeclaredConstructors(){

        Constructor<?>[] declaredConstructors = demoClazz.getDeclaredConstructors();
        for (Constructor item:declaredConstructors) {
            System.out.println(item.getName());

            System.out.println(Modifier.toString(item.getModifiers()));
            System.out.println("----------------");
        }
    }

    @Test
    public void testGetConstructors(){
        Constructor<?>[] constructors = demoClazz.getConstructors();
        System.out.println(constructors.length);
    }

    @Test
    public void testGetConstructor() throws NoSuchMethodException {
        Constructor<DemoClass> constructor = demoClazz.getConstructor(String.class);
        System.out.println(constructor.getName());
    }

    @Test
    public void testGetDeclaredconstructor() throws NoSuchMethodException {
        Constructor<DemoClass> constructor = demoClazz.getDeclaredConstructor(String.class);
        System.out.println(constructor.getName());
    }


}
