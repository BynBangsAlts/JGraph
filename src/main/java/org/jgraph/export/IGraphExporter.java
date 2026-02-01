package org.jgraph.export;

import org.jgraph.DefaultGraph;
import org.jgraph.IGraph;

public interface IGraphExporter<T> {
    String export(IGraph<T> graph);
}
