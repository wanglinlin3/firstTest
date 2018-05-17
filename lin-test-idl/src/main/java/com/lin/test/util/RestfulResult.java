package com.lin.test.util;


/**
 * restful结果类
 * 
 * @author yufushan
 * @param <T>
 */
public class RestfulResult<T> {

    private Boolean success = true;

    private String msg = "operation successful.";

    private Integer errorCode = 110000;

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    // @modifier baomingfeng
    public static <T> RestfulResult<T> create() {
        return new RestfulResult<T>();
    }

    // @modifier baomingfeng
    public RestfulResult<T> code(Integer errorCode) {
        this.setErrorCode(errorCode);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> status(boolean status) {
        this.setSuccess(status);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> ok() {
        this.setSuccess(true);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> ok(String message) {
        this.setSuccess(true);
        this.setMsg(message);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> fail() {
        this.setSuccess(false);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> fail(String message) {
        this.setSuccess(false);
        this.setMsg(message);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> fail(int errorCode, String message) {
        this.setErrorCode(errorCode);
        this.setSuccess(false);
        this.setMsg(message);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> message(String message) {
        this.setMsg(message);
        return this;
    }

    // @modifier baomingfeng
    public RestfulResult<T> data(T data) {
        this.setData(data);
        return this;
    }
}
