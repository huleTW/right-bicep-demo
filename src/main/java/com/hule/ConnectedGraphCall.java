package com.hule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConnectedGraphCall {
    private Map<String, List<String>> map;

    public ConnectedGraphCall(Map<String, List<String>> map) {
        this.map = map;
    }

    public List<String> getGraphCallPath() {
        return map.keySet().stream().flatMap(k -> getConnectedPath(k).stream())
                .collect(Collectors.toList());
    }

    private List<String> getConnectedPath(String startNode) {
        List<String> relatedNodes = map.get(startNode);
        List<String> result = new ArrayList<>();
        ArrayList<String> currentPath = new ArrayList<>();
        for (int i = 0; i < relatedNodes.size(); i++) {
            for (int j = i + 1; j < relatedNodes.size(); j++) {
                getPath(startNode, currentPath, result, relatedNodes.get(i), relatedNodes.get(j));
                getPath(startNode, currentPath, result, relatedNodes.get(j), relatedNodes.get(i));
            }
        }
        return result;
    }

    private void getPath(String startNode,
                         List<String> currentPath,
                         List<String> totalPath,
                         String currentNode,
                         String equalNode) {
        currentPath.add(currentNode);
        if (!map.containsKey(currentNode) || map.get(currentNode).isEmpty()
                || currentNode.equals(startNode) || currentNode.equals(equalNode)) {
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        List<String> nextNodes = map.get(currentNode);

        if (nextNodes.contains(equalNode)) {
            ArrayList<String> path = new ArrayList<>(currentPath);
            path.add(equalNode);
            path.add(0, startNode);
            totalPath.add(String.format("%s;%s->%s", String.join("->", path), startNode, equalNode));
        }
        for (String node : nextNodes) {
            if (currentPath.contains(node)) {
                continue;
            }
            getPath(startNode, currentPath, totalPath, node, equalNode);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
