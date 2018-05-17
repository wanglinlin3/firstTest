/*
 * Copyright (C) 2006-2018 Tuniu All rights reserved
 * Author:wanglinlin3
 * Date：2018年5月17日
 * Description: 功能描述
 */
package com.lin.test.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;

/**
 * CommonUtils.java
 *
 * @author wanglinlin3
 */
public class CommonUtils {

    public static JSONObject getRestParams(HttpServletRequest request) throws Exception {
        String data = getRestData(request);

        return JSONObject.fromObject(data);
    }

    private static String getRestData(HttpServletRequest request) throws Exception {
        if(request == null)
            return null;
        String method = request.getMethod();
        String ret = null;
        if(method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("DELETE"))
            ret = request.getQueryString();
        else
            ret = getBodyData(request);
        if(ret == null)
            return null;
        else
            return new String(Base64.decodeBase64(ret.getBytes("utf-8")), "utf-8");
    }

    private static String getBodyData(HttpServletRequest request) throws Exception {
        StringBuffer data = new StringBuffer();
        String line = null;
        try{
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null)
                data.append(line);
        }
        catch(IOException e){
            throw new Exception(e.getMessage(), e.getCause());
        }
        return data.toString();
    }
}
