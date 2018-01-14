package com.zy.innerClass;

public class Outer0 {

    public static void main(String[] args) {
        Outer0 outer = new Outer0();
        Outer0.Inner inner = outer.new Inner();

        System.out.println(outer);
        System.out.println(inner.getOuter0());
    }

    public Inner getInner() {
        return new Inner();
    }

    public class Inner {
        public void print(String str) {
            System.out.println(str);
        }

        public Outer0 getOuter0(){
            return Outer0.this;
        }
    }
}
