package com.hule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightTest {

    @Test
    public void should_get_2_when_1_add_1() {
        assertEquals(2, new Right().add(1, 1));

    }

}