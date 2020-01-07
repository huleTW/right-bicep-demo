package com.hule.group;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    @Test
    public void should_get_graph() {
        List<List<String>> source = Arrays.asList(
                Arrays.asList("A", "B", "C", "F"),
                Arrays.asList("A", "B", "D", "F"),
                Arrays.asList("A", "B", "E", "D"),
                Arrays.asList("D", "G", "H"),
                Arrays.asList("H", "B", "X"),
                Arrays.asList("F", "M", "E"));
        Graph graph = Graph.generate(source);
        assertEquals(graph.getNodes().size(), 10);
        assertEquals(graph.getLinks().size(), 21);
        Optional<Link> linkAB = graph.getLinks().stream().filter(e -> e.getSource().equals("A") && e.getTarget().equals("B")).findAny();
        assertTrue(linkAB.isPresent());
        assertEquals(linkAB.get().getValue(), 3);
    }

}