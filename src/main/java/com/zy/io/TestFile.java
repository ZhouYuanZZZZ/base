package com.zy.io;

import com.zy.io.utils.FileUtil;
import org.junit.Test;

import java.io.File;
import java.util.Date;

public class TestFile {

    private static final String path1 = "C:\\Users\\zy\\Desktop\\msg.txt";
    private static final String path2 = "C:\\Users\\zy\\Desktop";

    @Test
    public void testFile() {
        File file = new File(path1);

        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
    }

    @Test
    public void testFile1() {
        File file = new File(path1);

        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        long l = file.lastModified();

        Date date = new Date(l);
        System.out.println(date);

        long length = file.length();
        System.out.println(length);
    }

    @Test
    public void testFile2() {
        File file = new File(path2);

        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    @Test
    public void testFile3() {
        try {
            FileUtil.copyFile("C:\\Users\\zy\\Desktop\\msg.txt", "C:\\Users\\zy\\Desktop\\msg1.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
