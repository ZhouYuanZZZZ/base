package com.zy.pattern;

public class FactoryMethod {

    public static void main(String[] args) {
        AFactory aFactory = new AFactory();
        BFactory bFactory = new BFactory();

        aFactory.packProduct();
        bFactory.packProduct();
    }
}

interface Product {
    void testProduct();
}

abstract class Factory {

    abstract Product createProduct();

    void packProduct() {
        Product product = createProduct();
        product.testProduct();
    }
}

class AProduct implements Product {

    @Override
    public void testProduct() {
        System.out.println("A Test");
    }
}

class BProduct implements Product {

    @Override
    public void testProduct() {
        System.out.println("B Test");
    }
}

class AFactory extends Factory {

    @Override
    Product createProduct() {
        System.out.println("A Create");
        return new AProduct();
    }
}

class BFactory extends Factory {

    @Override
    Product createProduct() {
        System.out.println("B Create");
        return new BProduct();
    }
}
