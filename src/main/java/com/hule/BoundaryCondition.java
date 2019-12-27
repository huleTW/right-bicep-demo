package com.hule;

public class BoundaryCondition {

    public String getValueBy(int num) {
        if (num > 0) {
            return "hello";
        }
        return "world";
    }
}
