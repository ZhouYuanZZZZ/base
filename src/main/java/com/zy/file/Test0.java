package com.zy.file;

import com.zy.file.utils.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Test0 {

    //java创建多级目录
    @Test
    public void test0() throws IOException {
        String path = "E:/a/b/c.txt";
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
    }

    @Test
    public void test1() throws IOException {
        String path = "E:/a/b/c.txt";
        File file = new File(path);
        file.createNewFile();
    }

    @Test
    public void test3() throws IOException {
        String path = "E:/a/b/c.txt";
        FileUtil.createFile(path);
    }
}
