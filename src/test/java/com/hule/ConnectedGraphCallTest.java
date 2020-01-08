package com.hule;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ConnectedGraphCallTest {

    @Test
    public void should_get_connected_graph_call_path() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList("C", "B", "D"));
        map.put("B", Arrays.asList("D", "H"));
        map.put("C", Arrays.asList("D", "M"));
        map.put("D", Arrays.asList("E", "B"));
        map.put("E", Arrays.asList("B", "D"));
        List<String> total = new ConnectedGraphCall(map).getGraphCallPath();
        assertEquals(total.size(), 20);
    }

}