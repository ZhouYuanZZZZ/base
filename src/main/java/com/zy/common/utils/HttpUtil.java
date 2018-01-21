package com.zy.common.utils;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static HttpResponse getResponse(HttpParam param) {
        logger.info("param:{}",JSON.toJSONString(param));

        HttpURLConnection httpUrlConnection = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        HttpResponse httpResponse = new HttpResponse();
        try {
            if(param.getUrl() == null || "".equals(param.getUrl())){
                httpResponse.setResultFlag(false);
                httpResponse.setErrorMessage("url is invaild");
                return httpResponse;
            }
            if(param.getMethod() == null || "".equals(param.getMethod())){
                httpResponse.setResultFlag(false);
                httpResponse.setErrorMessage("method is invaild");
            }
            URL url = new URL(param.getUrl());
            URLConnection urlConnection = url.openConnection();
            httpUrlConnection = (HttpURLConnection) urlConnection;
            httpUrlConnection.setConnectTimeout(10000);
            httpUrlConnection.setRequestMethod(param.getMethod());

            for(Map.Entry<String,String> entry:param.getParams().entrySet()){
                httpUrlConnection.setRequestProperty(entry.getKey(),entry.getValue());
            }

            httpUrlConnection.connect();
            int responseCode = httpUrlConnection.getResponseCode();
            if(HttpURLConnection.HTTP_OK == responseCode){

                inputStream = httpUrlConnection.getInputStream();
                outputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024*500];
                int length;
                while ((length = inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,length);
                }
                outputStream.flush();
                String response = outputStream.toString("UTF-8");
                httpResponse.setResultFlag(true);
                httpResponse.setResultData(response);

            }else{
                httpResponse.setResultFlag(false);
                httpResponse.setErrorMessage("httpResponseCode is invaild"+":"+responseCode);
            }
            return httpResponse;

        }catch (Exception e){
            logger.error(e.toString());
            httpResponse.setResultFlag(false);
            httpResponse.setErrorMessage(e.toString());
            return httpResponse;
        }finally {
            try {
                outputStream.close();
                inputStream.close();
                httpUrlConnection.disconnect();
            }catch (Exception e){
               logger.error(e.toString());
            }
        }
    }

    public static HttpResponse getResponse(String url) {
        HttpParam httpParam = new HttpParam();
        httpParam.setUrl(url);
        httpParam.setMethod("GET");
        return getResponse(httpParam);
    }
}
