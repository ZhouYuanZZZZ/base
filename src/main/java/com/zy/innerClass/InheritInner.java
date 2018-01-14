package com.zy.innerClass;

public class InheritInner extends WithInner.Inner {
 
    // InheritInner() 是不能通过编译的，一定要加上形参 
    InheritInner(WithInner wi) { 
        wi.super(); 
    } 
 
    public static void main(String[] args) { 
        WithInner wi = new WithInner(); 
        InheritInner obj = new InheritInner(wi); 
    } 
} 
 
class WithInner { 
    class Inner { 
 
    } 
} 