package com.zhangbin.learncase.completablefuture;

/**
 * @author zhangbin
 * @Type Response
 * @Desc
 * @date 2018-03-08
 * @Version V1.0
 */
public class Response<T> {

    private String code;
    private String message;
    private T date;


    public Response(String code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
