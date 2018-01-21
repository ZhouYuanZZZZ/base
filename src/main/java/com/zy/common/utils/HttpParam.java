package com.zy.common.utils;

import java.util.HashMap;
import java.util.Map;

public class HttpParam {

    private String url;
    private String method;
    private Map<String,String> params = new HashMap<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
