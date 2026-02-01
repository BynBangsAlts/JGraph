import org.jgraph.DefaultGraph;
import org.jgraph.export.DotGraphExport;
import org.jgraph.node.Node;

import java.util.Random;

public class Test {
    //TEST !!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) {
        var random = new Random();
        var graph = new DefaultGraph<String>();

        int testNodeCount = 30;
        for(int i = 0; i < testNodeCount; i++) {
            var node = new Node<>("a" + i);
            graph.addNode(node);
        }

        for(int i = 0; i < testNodeCount - 1; i++) {
            var node = graph.getNodes().get(i);
            var nextNode = graph.getNodes().get(i + 1);
            if(i < (testNodeCount - 2) && random.nextBoolean()) {
                var otherNode = graph.getNodes().get(i + 2);
                graph.connect(node, otherNode);
            }

            graph.connect(node, nextNode);
        }

        System.out.println("==== DOT GRAPH ====");
        System.out.println(new DotGraphExport<String>().export(graph));
    }
}
