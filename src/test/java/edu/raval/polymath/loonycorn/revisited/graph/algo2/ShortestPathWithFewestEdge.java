package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.A;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.B;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.C;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.D;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.E;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.addEdge;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.AdjacencySetGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraphType;
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
  }


}