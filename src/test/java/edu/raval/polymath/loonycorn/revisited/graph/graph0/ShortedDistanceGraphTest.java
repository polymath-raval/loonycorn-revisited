package edu.raval.polymath.loonycorn.revisited.graph.graph0;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.ShortedDistanceGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph.GraphType;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph.Implementation;
import org.junit.Before;
import org.junit.Test;

public class ShortedDistanceGraphTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void compute() {
    IGraph graph;
    graph = IGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 7);
    graph.addEdge(5,0);
    graph.addEdge(1,2);
    graph.addEdge(2, 5);
    graph.addEdge(3,1);
    graph.addEdge(0,3);
    graph.addEdge(4,1);
    for(int i=0;i<graph.getNumberOfVertices();i++){
      System.out.println(i +"   " + new ShortedDistanceGraph().compute(graph, i));
    }

    System.out.println(new ShortedDistanceGraph().generatePath(graph, 4, 3));
  }

  @Test
  public void compute1() {
    IGraph graph;
    graph = IGraph.factory(Implementation.MATRIX, GraphType.UNDIRECTED, 7);
    graph.addEdge(5,0);
    graph.addEdge(1,2);
    graph.addEdge(2, 5);
    graph.addEdge(3,1);
    graph.addEdge(0,3);
    graph.addEdge(4,1);
    for(int i=0;i<graph.getNumberOfVertices();i++){
      System.out.println(i +"   " + new ShortedDistanceGraph().compute(graph, i));
    }

    System.out.println(new ShortedDistanceGraph().generatePath(graph, 4, 3));
  }
}