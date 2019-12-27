package com.hule;

import org.junit.Test;

public class ErrorConditionTest {
    @Test(expected = RuntimeException.class)
    public void should_force_error() {
        new ErrorCondition().withError(-1);
    }

}