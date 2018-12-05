package com.zy.pattern;

public class BuilderTest {

  public static void main(String[] args){
      ConcreteBuilder concreteBuilder = new ConcreteBuilder();
      concreteBuilder.builderBody();

      Person person = concreteBuilder.BuilderPersion();
      System.out.println(person);
  }
}

interface PersonBuilder {
    void builderHead();

    void builderBody();

    void builderFoot();

    Person BuilderPersion(); //组装

}

class ConcreteBuilder implements PersonBuilder {

    private Person person;

    public ConcreteBuilder() {
        person = new Person();
    }

    @Override
    public void builderHead() {
        person.setBody("body");
    }

    @Override
    public void builderBody() {
        person.setFoot("foot");
    }

    @Override
    public void builderFoot() {
        person.setHead("head");
    }

    @Override
    public Person BuilderPersion() {

        return this.person;
    }
}

class Person {
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
