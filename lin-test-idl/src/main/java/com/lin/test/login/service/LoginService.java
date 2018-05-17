/*
 * Copyright (C) 2006-2018 Tuniu All rights reserved
 * Author:wanglinlin3
 * Date：2018年5月17日
 * Description: 功能描述
 */
package com.lin.test.login.service;

/**
 * LoginService.java
 *
 * @author wanglinlin3
 */
public interface LoginService {
    public boolean successLogin(String userName, String password);

    public Integer getUserId(String userName);
}
