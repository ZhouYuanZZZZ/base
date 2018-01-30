package com.zy.common.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static HttpResponse getResponseWithTimeCount(HttpParam param) {

        logger.info("param:{}", JSON.toJSONString(param));

        HttpURLConnection httpUrlConnection = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        OutputStream os= null;

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
            httpUrlConnection.setReadTimeout(150000);
            httpUrlConnection.setRequestMethod(param.getMethod());

            //设置请求属性
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpUrlConnection.setRequestProperty("Charset", "UTF-8");

            StringBuilder stringBuilder = new StringBuilder();
            for(Map.Entry<String,String> entry:param.getParams().entrySet()){
                stringBuilder.append("&");
                stringBuilder.append(entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append(entry.getValue());
            }
            stringBuilder.substring(1,stringBuilder.length());
            String paramUrl = stringBuilder.toString();
            os = httpUrlConnection.getOutputStream();
            os.write(paramUrl.getBytes("UTF-8"));
            os.flush();


            httpUrlConnection.connect();
            int responseCode = httpUrlConnection.getResponseCode();
            httpResponse.setHttpResponseCode(responseCode);
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
                logger.error("httpResponseCode is invaild:{}",responseCode);
            }
            return httpResponse;

        }catch (Exception e){
            logger.error(e.toString());
            httpResponse.setResultFlag(false);
            httpResponse.setErrorMessage(e.toString());
            return httpResponse;
        }finally {
            try {
                if(outputStream != null){
                    outputStream.close();
                }
                if(inputStream != null){
                    inputStream.close();
                }
                if(os != null){
                    os.close();
                }

                httpUrlConnection.disconnect();
            }catch (Exception e){
                e.printStackTrace();
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

    public static HttpResponse getResponse(HttpParam httpParam){
        long startTime = System.currentTimeMillis();
        HttpResponse httpResponse = getResponseWithTimeCount(httpParam);
        long endTime = System.currentTimeMillis();

        logger.info("Http Request Time Cost:{}",endTime-startTime);
        logger.info("result:{}", JSON.toJSONString(httpResponse), SerializerFeature.WriteNullStringAsEmpty);

        return httpResponse;

    }
}
