package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted.IWeightedGraph.GraphType;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted.IWeightedGraph.Implementation;
import org.junit.Test;

public class MinimalSpanningTreeTest {


  @Test
  public void compute() {
    IWeightedGraph graph = IWeightedGraph.factory(Implementation.SET, GraphType.UNDIRECTED, 9);
    addEdge(graph, 0,4,5);
    addEdge(graph, 0,1,3);
    addEdge(graph, 0,2,15);

    addEdge(graph, 1,4,5);
    addEdge(graph, 1,2,2);
    addEdge(graph, 1,5,8);

    addEdge(graph, 2,5,9);

    addEdge(graph, 3,4,11);
    addEdge(graph, 3,5,4);

    addEdge(graph, 4,5,4);

    addEdge(graph, 6,7,10);
    addEdge(graph, 6,8,10);
    addEdge(graph, 8,9,20);




    System.out.println(new MinimalSpanningTree().compute(graph, 5));

  }

  private void addEdge(IWeightedGraph graph, int sourceVertex, int destinationVertex,
      int distance) {
    graph.addEdge(sourceVertex, new WeightedNode(destinationVertex, distance));
  }
}