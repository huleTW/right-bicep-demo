package com.hule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoundaryConditionTest {
    private BoundaryCondition boundaryCondition = new BoundaryCondition();

    @Test
    public void should_do_boundary_condition() {
        assertEquals("world", boundaryCondition.getValueBy(1));
        assertEquals("hello", boundaryCondition.getValueBy(-1));
    }


}
