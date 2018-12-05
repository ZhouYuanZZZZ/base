package com.zy.pattern;

public class TemplateMethod {

    public static void main(String[] args){
        Draw draw = new Draw();
       draw.process();
        System.out.println("--------");
        Query query = new Query();
        query.process();
    }
}

abstract class BankTemplateMethod{
    // 1.取号排队
    private void takeNumber() {
        System.out.println("取号排队。。");
    }

    // 2.每个子类不同的业务实现，由各自子类实现.
    abstract void transact();

    // 3.评价
    private void evaluate() {
        System.out.println("反馈评价..");
    }

    public void process(){
        takeNumber();
        transact();
        evaluate();
    }
}

class Draw extends BankTemplateMethod{

    @Override
    void transact() {
        System.out.println("draw money");
    }
}

class Query extends BankTemplateMethod{

    @Override
    void transact() {
        System.out.println("query");
    }
}
