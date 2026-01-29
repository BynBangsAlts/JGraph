import org.JGraph.JGraph;
import org.JGraph.graph.Edge;
import org.JGraph.JGraph;

public class TEST {

    //TEST !!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) {
        JGraph e = new JGraph(true);
        Edge.addEdge("A", "B");
        Edge.addEdge("C", "B");
        System.out.println(JGraph.getMap());
    }
}
