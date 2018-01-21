package com.zy.study.httpConnection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zy.common.utils.HttpConnectionInfo;
import com.zy.common.utils.HttpResponse;
import com.zy.common.utils.HttpUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Properties;

public class App {


    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Test
    public void test0() {
        String dataSourceUri = HttpConnectionInfo.getProperties("dataSourceUri");
        String path = "city";
        long start = System.currentTimeMillis();
        HttpResponse response = HttpUtil.getResponse(dataSourceUri + path);
        long end = System.currentTimeMillis();
        String s = JSON.toJSONString(response, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(s);
        System.out.println(end-start);
    }

    @Test
    public void test1() {

        long start = System.currentTimeMillis();
        HttpResponse response = HttpUtil.getResponse("http://www.baidu.com");
        long end = System.currentTimeMillis();
        String s = JSON.toJSONString(response, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(s);
        System.out.println(end-start);
    }
}
