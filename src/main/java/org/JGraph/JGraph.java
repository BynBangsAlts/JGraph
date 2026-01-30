package org.JGraph;

import org.JGraph.dot.DotExport;
import org.JGraph.graph.type;

import java.util.*;

public class JGraph {

    private static Map<String, List<String>> graph;
    private static final List<String> Format = new ArrayList<>();

    private static boolean yes;

    /**
     * Constructor
     * @param dups allow dups ?
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
     * Exports the Graph using print stream
     * @param typee Added it for more stuff in the future
     */
    public static void PrintGraph(type typee) {
        Format.clear();
        if (typee == type.DOT) {
            Format.add(DotExport.toDot(graph, true, "G"));
            return;
        }

        if (typee == type.NODE) {
            List<String> nodes = new ArrayList<>(graph.keySet());
            Collections.sort(nodes);
            Format.addAll(nodes);
            return;
        }

        List<String> fromNodes = new ArrayList<>(graph.keySet());
        Collections.sort(fromNodes);
        for (String from : fromNodes) {
            List<String> tos = graph.get(from);
            if (tos == null || tos.isEmpty()) {
                Format.add(from);
                continue;
            }
            List<String> sortedTos = new ArrayList<>(tos);
            Collections.sort(sortedTos);
            for (String to : sortedTos) {
                Format.add(from + " -> " + to);
            }
        }
    }

    /**
     * Returns the Graph field
     *
     * @return return the field
     */
    public static Map<String, List<String>> getMap() {
        return graph;
    }

    public static List<String> getFormat() {
        return Format;
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
