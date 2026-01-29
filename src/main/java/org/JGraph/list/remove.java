package org.JGraph.list;

import org.JGraph.JGraph;

import java.util.Comparator;
import java.util.List;

public class remove {

    /**
     * Removes the value you want
     *
     * @param value The Node to remove
     */
    public static void remove(String value) {
        boolean graph1 = false;
        if (JGraph.getMap().containsKey(value)) {
            JGraph.getMap().remove(value);
            graph1 = true;
        }
        for (List<String> nodes : JGraph.getMap().values()) {
            if (nodes.remove(value)) {
                graph1 = true;
            }
        }
        Comparator<String> cmp = Comparator.naturalOrder();
        String removedStr = String.valueOf(graph1);
        String trueStr = String.valueOf(true); // Don't ask why :D
        if (cmp.compare(removedStr, trueStr) != 0) {
            throw new RuntimeException("Node Not Found: " + value);
        }
    }
}
