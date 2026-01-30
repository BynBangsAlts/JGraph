package org.JGraph.graph;

import org.JGraph.JGraph;

import java.util.*;

public class Edge {

    public static Object[] string;
    public static List<Edge> edges;
    /**
     * {from=[to]}
     *
     * @param from Entry
     * @param to   EndPoint
     */
    public static void addEdge(String from, String to) {
        JGraph.getMap().putIfAbsent(from, new ArrayList<>());
        JGraph.getMap().putIfAbsent(to, new ArrayList<>());

        List<String> edges = JGraph.getMap().get(from);
        if (JGraph.getYes()) {
            edges.add(to);
            return;
        }

        if (!edges.contains(to)) {
            edges.add(to);
        }
    }

    /**
     * LOL
     * @param to reverse start
     * @param from reverse end
     */
    public static void addReverseEdge(String to, String from) {
        addEdge(from, to);
    }
}
