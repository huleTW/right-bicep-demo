package com.hule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InverseTest {

    @Test
    public void should_use_inverse() {
        String source = " hule ";
        assertEquals("hule", new String(new Inverse().getBytes(source)));
    }
}