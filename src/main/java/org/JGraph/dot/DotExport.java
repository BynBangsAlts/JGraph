package org.JGraph.dot;

import org.JGraph.JGraph;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DotExport implements DotInterface{

    public static boolean file;

    /**
     * Constructor
     * @param f file name
     */
    public DotExport(boolean f) {
        this.file = f;
    }

    /**
     * Export the values
     */
    @Override
    public void export() {
        String dot = toDot(JGraph.getMap(), true, "G");
        if (file) {
            try {
                Files.write(Path.of("graph.dot"), dot.getBytes(StandardCharsets.UTF_8));
            } catch (IOException ignored) {
            }
            return;
        }

        JGraph.getFormat().clear();
        JGraph.getFormat().add(dot);
    }

    /**
     * Turns the graph to dot
     * @param graph Graph list
     * @param directed Check
     * @param graphName Graphs name
     * @return return string builder
     */
    public static String toDot(Map<String, List<String>> graph, boolean directed, String graphName) {
        StringBuilder sb = new StringBuilder();
        String header = directed ? "digraph" : "graph";
        String lolol = directed ? "->" : "--";

        sb.append(header).append(' ').append(escapeId(graphName)).append(" {\n");

        List<String> fromNodes = new ArrayList<>(graph.keySet());
        Collections.sort(fromNodes);

        for (String from : fromNodes) {
            List<String> tos = graph.get(from);
            if (tos == null || tos.isEmpty()) {
                sb.append("  ").append(escapeId(from)).append(";\n");
                continue;
            }

            List<String> sortedTos = new ArrayList<>(tos);
            Collections.sort(sortedTos);
            for (String to : sortedTos) {
                sb.append("  ")
                        .append(escapeId(from))
                        .append(' ')
                        .append(lolol)
                        .append(' ')
                        .append(escapeId(to))
                        .append(";\n");
            }
        }

        sb.append("}\n");
        return sb.toString();
    }

    /**
     *
     * @param raw
     * @return
     */

    /**
     * Identifier
     * @param raw param used to check if the dot is valid
     * @return return s
     */
    private static String escapeId(String raw) {
        if (raw == null) {
            return "\"\"";
        }
        String s = raw.replace("\\", "\\\\").replace("\"", "\\\"");
        return "\"" + s + "\"";
    }
}
