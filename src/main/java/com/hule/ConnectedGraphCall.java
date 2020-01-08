package com.hule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectedGraphCall {

    public static void getGraphCallPath(List<String> currentPath, List<List<String>> totalPath,
                                        String currentNode, Map<String, List<String>> relation,
                                        String equalNode) {
        if (!relation.containsKey(currentNode) || relation.get(currentNode).isEmpty()) {
            return;
        }
        List<String> nextNodes = relation.get(currentNode);

        if (nextNodes.contains(equalNode)) {
            ArrayList<String> path = new ArrayList<>(currentPath);
            path.add(currentNode);
            path.add(equalNode);
            totalPath.add(path);
        }
        currentPath.add(currentNode);

        for (String node : nextNodes) {
            if (currentPath.contains(node)) {
                continue;
            }
            getGraphCallPath(currentPath, totalPath, node, relation, equalNode);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
