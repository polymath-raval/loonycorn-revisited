package edu.raval.polymath.loonycorn.revisited.graph.graph0;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph.GraphType;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph.Implementation;
import org.junit.Test;

public class TopologicalSortTest {

  @Test
  public void sort() {
    IGraph graph;
    graph = IGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 7);
    graph.addEdge(0,5);
    graph.addEdge(1,2);
    graph.addEdge(2, 5);
    graph.addEdge(3,1);
    graph.addEdge(3,0);
    graph.addEdge(4,1);
    System.out.println(new TopologicalSort().sort1(graph));
  }

  @Test
  public void sort1() {
    IGraph graph;
    graph = IGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 7);
    graph.addEdge(0,3);
    graph.addEdge(1,2);
    graph.addEdge(2, 5);
    graph.addEdge(3,1);
    graph.addEdge(4,1);
    graph.addEdge(5,0);

    System.out.println(new TopologicalSort().sort1(graph));
  }
}