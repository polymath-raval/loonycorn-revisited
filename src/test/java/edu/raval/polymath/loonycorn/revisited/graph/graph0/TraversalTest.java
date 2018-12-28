package edu.raval.polymath.loonycorn.revisited.graph.graph0;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph.GraphType;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph.Implementation;
import org.junit.Test;

public class TraversalTest {


  public IGraph setUp1() {
    IGraph graph;

    graph = IGraph.factory(Implementation.MATRIX, GraphType.UNDIRECTED, 10);
    graph.addEdge(0,5);
    graph.addEdge(0,2);
    graph.addEdge(5,3);
    graph.addEdge(5,4);
    graph.addEdge(2,1);
    graph.addEdge(2,4);
    graph.addEdge(4,3);
    graph.addEdge(6,7);
    graph.addEdge(6,9);
    graph.addEdge(7,8);

    return graph;
  }

  public IGraph setUp2() {
    IGraph graph;

    graph = IGraph.factory(Implementation.MATRIX, GraphType.UNDIRECTED, 6);
    graph.addEdge(1,2);
    graph.addEdge(1,3);
    graph.addEdge(2,4);
    graph.addEdge(2,5);
    graph.addEdge(3,5);
    graph.addEdge(4,5);

    return graph;
  }

  @Test
  public void breadthFirst() {
    System.out.println(new Traversal().breadthFirst(setUp1()));
  }

  @Test
  public void depthFirst() {
    System.out.println(new Traversal().depthFirst(setUp1()));
  }

  @Test
  public void depthFirst1() {
    System.out.println(new Traversal().depthFirst(setUp2()));
  }
}