package com.zy.pattern;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Prototype {

    public static void main(String[] args){

        Book book = new Book();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("will0");
        strings.add("will1");

        book.setTitle("title0");
        book.setAuthors(strings);

        System.out.println(book);

        try {
            Book clone = (Book) book.clone();
            clone.setTitle("xxxxxxxxxxx");
            clone.getAuthors().add("888888888888");
            System.out.println(clone);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(book);

    }
}

class Book implements Cloneable{

    private String title;
    private ArrayList<String> authors = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();

        //深复制
        ArrayList<String> authors = (ArrayList<String>) this.authors.clone();
        book.setAuthors(authors);

        return book;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
