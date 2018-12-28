package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted.IWeightedGraph.GraphType;
import edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted.IWeightedGraph.Implementation;
import org.junit.Test;

public class ShortedDistanceWeightedGraphTest {

  @Test
  public void computeDistanceTable() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 6);
    addEdge(graph, 0, 1, 5);
    addEdge(graph, 0, 3, 5);
    addEdge(graph, 1, 2, 5);
    addEdge(graph, 1, 5, 2);
    addEdge(graph, 2, 5, 1);
    addEdge(graph, 3, 4, 1);
    addEdge(graph, 4, 1, 1);
    addEdge(graph, 4, 2, 10);
    addEdge(graph, 4, 5, 12);

    for (int i = 4; i < 5; i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeDijkstraDistanceTable(graph, i));
    }
  }

  @Test
  public void computeDistanceTable1() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.UNDIRECTED, 6);
    addEdge(graph, 0, 1, 5);
    addEdge(graph, 0, 3, 1);
    addEdge(graph, 1, 2, 5);
    addEdge(graph, 1, 5, 2);
    addEdge(graph, 2, 5, 1);
    addEdge(graph, 3, 4, 1);
    addEdge(graph, 4, 1, 1);
    addEdge(graph, 4, 2, 10);
    addEdge(graph, 4, 5, 12);

    for (int i = 4; i < 5; i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeDijkstraDistanceTable(graph, i));
    }
  }

  private void addEdge(IWeightedGraph graph, int sourceVertex, int destinationVertex,
      int distance) {
    graph.addEdge(sourceVertex, new WeightedNode(destinationVertex, distance));
  }

  @Test
  public void computeDistanceTable2() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.UNDIRECTED, 4);

    addEdge(graph, 0, 1, 5);
    addEdge(graph, 1, 3, 1);
    addEdge(graph, 0, 2, 2);
    addEdge(graph, 2, 1, 1);
    addEdge(graph, 2, 3, 7);

    for (int i = 0; i < 1; i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeDijkstraDistanceTable(graph, i));
    }
  }

  @Test
  public void computeDistanceTable3() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 5);

    addEdge(graph, 0, 1, 2);
    addEdge(graph, 0, 2, 3);
    addEdge(graph, 1, 3, 2);
    addEdge(graph, 2, 4, 6);
    addEdge(graph, 4, 1, -5);
    addEdge(graph, 4, 3, -6);

    for (int i = 0; i < 1; i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeBellmanFordDistanceTable1(graph, i));
    }
  }

  @Test(expected = RuntimeException.class)
  public void computeDistanceTable4() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 5);

    addEdge(graph, 0, 1, 2);
    addEdge(graph, 0, 2, 3);
    addEdge(graph, 1, 3, 2);
    addEdge(graph, 2, 4, 6);
    addEdge(graph, 4, 1, -5);
    addEdge(graph, 3, 4, 2);

    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeBellmanFordDistanceTable1(graph, i));
    }
  }


  @Test
  public void computeDistanceTable5() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 5);

    addEdge(graph, 0, 1, 2);
    addEdge(graph, 0, 2, 3);
    addEdge(graph, 1, 3, 2);
    addEdge(graph, 2, 4, 6);
    addEdge(graph, 4, 1, -5);
    addEdge(graph, 3, 4, 3);

    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeBellmanFordDistanceTable1(graph, i));
    }
  }

  @Test
  public void computeDistanceTable6() {
    IWeightedGraph graph;
    graph = IWeightedGraph.factory(Implementation.MATRIX, GraphType.DIRECTED, 5);

    addEdge(graph, 0, 1, 2);
    addEdge(graph, 0, 2, 3);
    addEdge(graph, 1, 3, 2);
    addEdge(graph, 2, 4, 6);
    addEdge(graph, 4, 1, -5);
    addEdge(graph, 4, 3, 6);

    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      System.out.println(
          i + "   " + new ShortedDistanceWeightedGraph().computeBellmanFordDistanceTable1(graph, i));
    }
  }
}