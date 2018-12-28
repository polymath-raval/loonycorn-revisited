package edu.raval.polymath.loonycorn.revisited.graph.graph0;


import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph;

public class PrepareTestSet {

  /**
   * A(0) --> B(1)-------
   *  |        |        |
   *  |        |        v
   *  |        |       D(3)
   *  |        |        ^
   *  v        v        |
   * C(2) --> E(4)------
   */

  public static IGraph setUp(IGraph.Implementation implementation, IGraph.GraphType type) throws Exception {
    IGraph graph = IGraph.factory(implementation, type, 5);
    graph.addEdge(0,1);
    graph.addEdge(0,2);
    graph.addEdge(1,3);
    graph.addEdge(1,4);
    graph.addEdge(2,4);
    graph.addEdge(4,3);
    return graph;
  }
}
