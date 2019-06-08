package com.beini.http;

/**
 * 返回数据的状态码
 */
public class NetCode {
    /**
     * 成功
     */
    public final static int CODE_SUCCESS = 1;
    /**
     * 失败
     */
    public final static int CODE_FAILED = 0;
    /**
     * 用户已经登录
     */
    public final static int CODE_ALREADY_LOGINED = 10001;
    /**
     * 用户已经存在
     */
    public final static int CODE_ALREADY_EXIST = 10002;
}
