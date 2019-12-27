package com.hule;

public class ErrorCondition {

    public String withError(int num) {
        if (num < 0) {
            throw new RuntimeException("error");
        }
        return "success";
    }
}
