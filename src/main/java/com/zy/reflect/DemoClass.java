package com.zy.reflect;

public class DemoClass {

    private String name;

    public DemoClass(){
        System.out.println("public DemoClass");
    }

    private DemoClass(String name){
        System.out.println("private DemoClass");

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String publicMethod0(){
        return "publicMethod0";
    }

    private String privateMethod0(){
        return "privateMethod0";
    }
}
