package com.cpmanager.service.commonModels;

public class AuthApiResponse<T> {

    private int status;
    private boolean valid;
    private  String message;
    private Object result;

    public AuthApiResponse(int status, boolean valid, Object result) {
        this.status = status;
        this.valid = valid;
        this.result = result;
    }

    public AuthApiResponse(int status, boolean valid) {
        this.status = status;
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public AuthApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
