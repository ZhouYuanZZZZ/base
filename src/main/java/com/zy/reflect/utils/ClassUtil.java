package com.zy.reflect.utils;

import java.util.List;

public class ClassUtil {

    /**
     * 取得某个接口下所有实现这个接口的类
     */
    public static List<Class> getAllClassByInterface(Class c){
        List<Class> returnClassList = null;
        if(c.isInterface()){

            // 获取当前的包名
            String packageName = c.getPackage().getName();
        }

        return null;
    }

}
