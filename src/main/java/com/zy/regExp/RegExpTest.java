package com.zy.regExp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

    @Test
    public void test0(){
        String string = "dfsfferferwf.javafwefw wefwfwef .JAVA";
        String reg = ".java";
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
        }

    }
}
