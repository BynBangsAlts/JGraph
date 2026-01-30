package org.JGraph;

import java.util.*;

public class JGraph {

    public static Map<String, List<String>> graph;

    private static boolean yes;

    /**
    * Constructor
    * @params dups Do you want to allow dups
    */
    public JGraph(boolean dups) {
        this.yes = dups;
        this.graph = new HashMap<>();
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
