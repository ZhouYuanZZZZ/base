package com.zy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static void main(String[] args) {
        Target target = new Target();

        Action proxy = (Action) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), Target.class.getInterfaces(), new RunInvocationHandler(target));
        proxy.runAction("zzzz");
    }
}

 interface Action {
    void runAction(String s);
}

class Target implements Action {

    @Override
    public void runAction(String s) {
        System.out.println("run:" + s);
    }
}

class RunInvocationHandler implements InvocationHandler {

    private Target target;

    public RunInvocationHandler(Target target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before run");
       method.invoke(target,args);
        System.out.println("end run");
        
        return null;
    }
}
