package com.dian.demo.common.result;

public class Result<T> {

    public static final String SUCCESS_MSG = "操作成功";
    public static final String FAIL_MSG = "操作失败";

    private Integer resultCode;

    private String resultMsg;

    private T data;

    public Result() {
    }

    public Result(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Result(Integer resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
