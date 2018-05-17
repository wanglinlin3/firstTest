/*
 * Copyright (C) 2006-2018 Tuniu All rights reserved
 * Author:wanglinlin3
 * Date：2018年5月17日
 * Description: 功能描述
 */
package com.lin.test.login.action;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.test.login.service.LoginService;
import com.lin.test.util.RestfulResult;

/**
 * LoginAction.java
 *
 * @author wanglinlin3
 */
@Controller
public class LoginAction {
    private static Logger logger = Logger.getLogger(LoginAction.class);
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody String str) throws Exception {
        RestfulResult<Object> res = new RestfulResult<Object>();
        try{
            JSONObject params = JSONObject.fromObject(str);
            logger.info("接口 LoginAction login.htm  params:" + params);
            String userName = params.getString("userName");
            String password = params.getString("password");
            if(loginService.successLogin(userName, password)){
                loginService.getUserId(userName);
            }
            else{
                res.fail(10002, "用户名密码验证失败！");
            }
        }
        catch(Exception e){
            res.fail(10001, e.getMessage());
            logger.error("接口 LoginAction login.htm Failed:" + res);
        }
        return JSONObject.fromObject(res).toString();
    }
}
