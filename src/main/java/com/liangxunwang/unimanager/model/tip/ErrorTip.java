package com.liangxunwang.unimanager.model.tip;

public class ErrorTip implements Tip {
    private boolean success;
    private int code;

    public ErrorTip(int code) {
        super();
        this.success = false;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
