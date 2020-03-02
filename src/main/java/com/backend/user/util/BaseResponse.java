package com.backend.user.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BaseResponse {
    private HttpStatus status;
    private Object result;
    private ArrayList<String> error;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ArrayList<String> getError() {
        return error;
    }

    public void setError(ArrayList<String> error) {
        this.error = error;
    }
}
