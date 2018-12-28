package edu.raval.polymath.loonycorn.revisited.graph.usecase;

import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.A;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.B;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.C;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.D;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.E;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.addEdge;

import edu.raval.polymath.loonycorn.revisited.graph.algo.AdjacencySetGraph;
import edu.raval.polymath.loonycorn.revisited.graph.algo.GraphMinimumDistanceDijkstraAlgo;
import edu.raval.polymath.loonycorn.revisited.graph.algo.GraphMinimumDistanceWithNumberOfVerticesDijkstraAlgo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphType;
import org.junit.Before;
import org.junit.Test;

public class ShortestPathWithFewestEdge {

  IGraph graph;

  @Before
  public void setup() {
    graph = new AdjacencySetGraph(IGraphType.DIRECTED);
    addEdge(graph, A, B, 5);
    addEdge(graph, B, D, 3);
    addEdge(graph, A, C, 1);
    addEdge(graph, C, E, 3);
    addEdge(graph, B, E, 5);
    addEdge(graph, E, D, 4);
  }

  @Test
  public void execute() {
    System.out.println(new GraphMinimumDistanceDijkstraAlgo().compute(graph, A, D));
    System.out.println(new GraphMinimumDistanceWithNumberOfVerticesDijkstraAlgo().compute(graph, A, D));
  }


}