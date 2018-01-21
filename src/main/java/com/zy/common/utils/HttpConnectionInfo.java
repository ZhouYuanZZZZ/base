package com.zy.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class HttpConnectionInfo {

    private static final Logger logger = LoggerFactory.getLogger(HttpConnectionInfo.class);

    private static Properties properties;

    static {
        try {
            String classPath = HttpConnectionInfo.class.getResource("/").getPath();
            String path = classPath + "common/connection.properties";
            InputStream inputStream = new FileInputStream(new File(path));
            properties = new Properties();
            properties.load(inputStream);
            logger.info("HttpConnectionInfo load successfully");
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}
