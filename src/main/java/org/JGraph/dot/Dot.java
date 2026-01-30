package org.JGraph.dot;

import org.JGraph.graph.Edge;

public class Dot {

    /**
     * Make a dot
     * @param from start
     * @param to end
     */
    public static void graph(String from, String to) {
        Edge.addEdge(from, to);
    }
}
