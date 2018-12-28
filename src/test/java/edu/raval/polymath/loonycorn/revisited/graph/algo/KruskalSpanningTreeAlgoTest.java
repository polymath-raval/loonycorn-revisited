package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphSpanningTree;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphType;
import org.junit.Assert;
import org.junit.Test;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.*;

public class KruskalSpanningTreeAlgoTest {
  IGraphSpanningTree spanningTree = new KruskalSpanningTreeAlgo();

  @Test
  public void compute() {
    IGraph graph = new AdjacencySetGraph(IGraphType.UNDIRECTED);
    addEdge(graph, C, F, 3);
    addEdge(graph, C, B, 1);
    addEdge(graph, B, E, 1);
    addEdge(graph, B, F, 4);
    addEdge(graph, E, F, 4);
    addEdge(graph, C, E, 2);


    addEdge(graph, X, Y, 3);
    addEdge(graph, X, Z, 1);
    addEdge(graph, Z, P, 1);
    addEdge(graph, Z, Y, 4);
    addEdge(graph, P, Y, 4);
    addEdge(graph, X, P, 2);

    IGraph result = spanningTree.compute(graph);

    for (String node : result.getNodes()) {
      for(EdgeInfo edgeInfo : result.getNeighbours(node)){
        System.out.println(edgeInfo);
      }
    }
  }

  @Test
  public void checkIfLoopExists(){
    KruskalSpanningTreeAlgo algo = new KruskalSpanningTreeAlgo();
    IGraph graph = new AdjacencySetGraph(IGraphType.UNDIRECTED);

    addEdge(graph, X, Y, 3);
    Assert.assertFalse(algo.checkIfCycleExists(graph, X));

    addEdge(graph, X, Z, 1);
    Assert.assertFalse(algo.checkIfCycleExists(graph, X));

    addEdge(graph, Z, P, 1);
    Assert.assertFalse(algo.checkIfCycleExists(graph, X));

    addEdge(graph, Z, Y, 4);
    Assert.assertTrue(algo.checkIfCycleExists(graph, X));

    removeEdge(graph, Z, Y, 4);
    Assert.assertFalse(algo.checkIfCycleExists(graph, X));


    addEdge(graph, C, F, 3);
    Assert.assertFalse(algo.checkIfCycleExists(graph, C));

    addEdge(graph, C, B, 1);
    Assert.assertFalse(algo.checkIfCycleExists(graph, C));

    addEdge(graph, B, E, 1);
    Assert.assertFalse(algo.checkIfCycleExists(graph, C));

    addEdge(graph, B, F, 4);
    Assert.assertTrue(algo.checkIfCycleExists(graph, C));

    addEdge(graph, Z, Y, 4);
    Assert.assertTrue(algo.checkIfCycleExists(graph, X));

  }
}