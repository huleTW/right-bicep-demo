package com.hule;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CrossCheckTest {
    @Test
    public void should_cross_check() {
        List<String> source = Arrays.asList("2", "a", "f", "b", "1");
        List<String> sort = new CrossCheck().sort(source);
        assertEquals(String.join("", sort), Stream.of("2", "a", "f", "b", "1").sorted().collect(Collectors.joining()));
    }

    @Test
    public void should_test_add() {
        List<String> source = Arrays.asList("2", "a", "f", "b", "1");
        List<String> results = new CrossCheck().add(source, "test");
        assertEquals(source.size() + 1, results.size());
        assertEquals(results.get(results.size() - 1), "test");
    }
}
