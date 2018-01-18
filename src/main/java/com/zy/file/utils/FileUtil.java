package com.zy.file.utils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static boolean createFile(String path) throws IOException {
        File file = null;
        try {
            if(path == null || path.equals("")){
                throw new IOException("path error");
            }else {
                file = new File(path);
                if(file.exists()){
                    file.delete();
                }else {
                    if(!file.getParentFile().exists()){
                        file.getParentFile().mkdirs();
                    }
                }
                file.createNewFile();
                return true;
            }
        }catch (Exception e){
            throw new IOException("create fail error");
        }
    }
}
