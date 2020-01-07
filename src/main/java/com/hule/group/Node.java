package com.hule.group;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Node {
    private String id;

    private Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static List<Node> generateNodes(List<List<String>> source) {
        return source.stream().flatMap(Collection::stream)
                .distinct()
                .map(Node::new)
                .collect(Collectors.toList());
    }
}
