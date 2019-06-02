package com.beini.http;

/**
 * Created by beini on 2017/7/8.
 */
public class BaseResponseJson {
    /**
     * ReturnCode : 0:失败，1：成功
     * ReturnMessage :
     */

    private int ReturnCode;

    private String ReturnMessage;

    public int getReturnCode() {
        return ReturnCode;
    }

    public void setReturnCode(int ReturnCode) {
        this.ReturnCode = ReturnCode;
    }

    public String getReturnMessage() {
        return ReturnMessage;
    }

    public void setReturnMessage(String ReturnMessage) {
        this.ReturnMessage = ReturnMessage;
    }
}
