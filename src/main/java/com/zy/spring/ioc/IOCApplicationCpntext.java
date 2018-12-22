package com.zy.spring.ioc;

import com.zy.reflect.utils.ClassUtil;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class IOCApplicationCpntext {

    private String basePackage;

    private ConcurrentHashMap<String, Object> initBean = null;

    public IOCApplicationCpntext(String basePackage) {
        this.basePackage = basePackage;
    }

    //使用反射的方式获取basePackage下所有有注解的bean的运行时类
    private List<Class<?>> findClassExisService() {
        // 1.使用反射机制获取该包下所有的类
        if (StringUtils.isEmpty(this.basePackage)) {
            throw new RuntimeException("扫包地址不能为空!");
        }

        List<Class<?>> classes = ClassUtil.getClassByPackName(this.basePackage, true);

        // 3.存放类上有bean注入注解
        List<Class<?>> exisClassesAnnotation = new ArrayList<>();

        Iterator<Class<?>> iterator = classes.iterator();
        while (iterator.hasNext()) {
            Class<?> item = iterator.next();
            ExtService annotation = item.getAnnotation(ExtService.class);
            if (annotation != null) {
                exisClassesAnnotation.add(item);
            }
        }

        return exisClassesAnnotation;
    }

    public Object getBean(String beanId) throws InstantiationException, IllegalAccessException {

        // 1.使用反射机制获取该包下所有的类已经存在bean的注解类
        List<Class<?>> listClassesAnnotation = findClassExisService();
        if (listClassesAnnotation == null || listClassesAnnotation.isEmpty()) {
            throw new RuntimeException("没有需要初始化的bean");
        }

        // 2.使用Java反射机制初始化对象
        initBean = initBeans(listClassesAnnotation);
        if (initBean == null || initBean.isEmpty()) {
            throw new RuntimeException("初始化bean为空!");
        }

        Object bean = initBean.get(beanId);

        return bean;
    }

    //初始化容器中的bean对象
    private ConcurrentHashMap<String, Object> initBeans(List<Class<?>> listClassesAnnotation) throws IllegalAccessException, InstantiationException {

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        for (Class item : listClassesAnnotation) {
            ExtService annotation = (ExtService) item.getAnnotation(ExtService.class);

            String beanId = annotation.beanId();
            map.put(beanId, item.newInstance());

        }
        return map;
    }

}
