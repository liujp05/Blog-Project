package com.jpliu.common;

public enum  LoginStatus {

    VALID(0),
    INVALID(1);

    private Integer status;

    LoginStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

}
