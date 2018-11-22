package com.zy.io.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static boolean createFile(String path) throws Exception {
        File file = null;
        try {
            if(path == null || path.equals("")){
                logger.error("path error");
                throw new Exception("path error");
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
            logger.error("create fail error",e);
            throw  e;
        }
    }

    public static void copyFile(String sourcePath,String targetPath) throws Exception{
        if(sourcePath==null || sourcePath.equals("")){
            logger.error("sourcePath empty");
            throw new RuntimeException("sourcePath empty");
        }
        if(targetPath==null || targetPath.equals("")){
            logger.error("targetPath empty");
            throw new RuntimeException("targetPath empty");
        }

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        
        try {
             fileInputStream = new FileInputStream(new File(sourcePath));
             bufferedInputStream = new BufferedInputStream(fileInputStream);

             fileOutputStream = new FileOutputStream(new File(targetPath));
             bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] tempByte = new byte[1024*1024];
            int len = 0;
            while((len = bufferedInputStream.read(tempByte))!=-1){
                bufferedOutputStream.write(tempByte,0,len);
            }
            bufferedOutputStream.flush();
        } catch (Exception e) {
            logger.error("copyFile error");
            throw e;
        }finally {
           if(bufferedInputStream!=null){
               bufferedInputStream.close();
           }
           
           if(bufferedOutputStream!=null){
               bufferedOutputStream.close();
           }
           
           if(fileInputStream!=null){
               fileInputStream.close();
           }
           
           if (fileOutputStream!=null){
               fileOutputStream.close();
           }
        }

    }
}
