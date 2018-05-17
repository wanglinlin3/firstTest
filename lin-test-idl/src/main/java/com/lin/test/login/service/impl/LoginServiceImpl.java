/*
 * Copyright (C) 2006-2018 Tuniu All rights reserved
 * Author:wanglinlin3
 * Date：2018年5月17日
 * Description: 功能描述
 */
package com.lin.test.login.service.impl;

import org.springframework.stereotype.Service;

import com.lin.test.login.service.LoginService;

/**
 * LoginServiceImpl.java
 *
 * @author wanglinlin3
 */
@Service
public class LoginServiceImpl implements LoginService {

    public boolean successLogin(String userName, String password) {
        if(userName.equals(password)){
            return true;
        }
        return false;
    }

    public Integer getUserId(String userName) {
        return 666;
    }

}
