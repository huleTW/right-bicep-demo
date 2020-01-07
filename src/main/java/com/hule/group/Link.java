package com.hule.group;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Link {
    private String source;
    private String target;
    private long value;

    public Link(String key, Long value) {
        String[] nodes = key.split(",");
        this.source = nodes[0];
        this.target = nodes[1];
        this.value = value;
    }

    public static List<Link> generateLinks(Map<String, Long> intersection) {
        return intersection.entrySet().stream().map(e -> new Link(e.getKey(), e.getValue())).collect(Collectors.toList());
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
