package com.hule.group;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;


public class Graph {
    private List<Node> nodes;
    private List<Link> links;

    public static Graph generate(List<List<String>> source) {
        Graph graph = new Graph();
        Map<String, Long> intersection = getIntersectionCount(source);
        graph.setNodes(Node.generateNodes(source));
        graph.setLinks(Link.generateLinks(intersection));
        return graph;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    private static Map<String, Long> getIntersectionCount(List<List<String>> source) {
        Map<String, Long> intersection = new HashMap<>();
        for (List<String> list : source) {
            List<String> com = getCom(list);
            for (String key : com) {
                if (intersection.containsKey(key)) {
                    intersection.put(key, intersection.get(key) + 1);
                } else {
                    intersection.put(key, 1L);
                }
            }
        }
        return intersection;
    }

    private static List<String> getCom(List<String> intersection) {
        if (intersection.size() < 2) {
            return emptyList();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < intersection.size(); i++) {
            for (int j = i + 1; j < intersection.size(); j++) {
                result.add(key(intersection.get(i), intersection.get(j)));
            }
        }
        return result;
    }

    private static String key(String s1, String s2) {
        if (s1.compareTo(s2) > 0) {
            return s2 + "," + s1;
        } else {
            return s1 + "," + s2;
        }
    }

}
