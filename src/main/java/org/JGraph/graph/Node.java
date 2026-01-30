package org.JGraph.graph;


import org.JGraph.JGraph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    /**
     * Adds a single node
     *
     * @param node
     */
    public static void addNode(String node) {
        JGraph.getMap().putIfAbsent(node, new ArrayList<>());
    }
}
