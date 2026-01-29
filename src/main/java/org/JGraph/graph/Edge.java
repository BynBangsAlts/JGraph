package org.JGraph.graph;

import org.JGraph.JGraph;

import java.util.ArrayList;
import java.util.List;

public class Edge {

    /**
     * {from=[to]}
     *
     * @param from Entry
     * @param to   EndPoint
     */
    public static void addEdge(String from, String to) {
        List<String> edges = JGraph.getMap().computeIfAbsent(from, k -> new ArrayList<>());
        if (String.valueOf(JGraph.getYes()).equals("true")) {
            if (!edges.contains(to)) {
                edges.add(to);
            }
        }
    }
}


