package org.JGraph;

import java.util.*;

public class JGraph {

    public static Map<String, List<String>> graph = new HashMap<>();

    private static boolean yes;

    public JGraph(boolean dups) {
        this.yes = dups;
    }

    /**
     * Clears the graph
     */
    public static void Clear() {
        graph.clear();
    }

    /**
     * Returns the Graph field
     *
     * @return return the field
     */
    public static Map<String, List<String>> getMap() {
        return graph;
    }

    /**
     * Used to get the value of Yes
     *
     * @return return value of Yes
     */
    public static boolean getYes() {
        return yes;
    }
}