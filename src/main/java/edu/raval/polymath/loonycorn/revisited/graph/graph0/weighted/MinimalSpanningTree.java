package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.DistanceTable;
import java.util.HashSet;
import java.util.Set;

public class MinimalSpanningTree {

  public DistanceTable compute(IWeightedGraph graph, int vertex) {
    DistanceTable distanceTable = new DistanceTable(graph.getNumberOfVertices(), vertex);
    Set<Integer> spanningTree = new HashSet<>();
    spanningTree.add(vertex);
    System.out.println(spanningTree);
    System.out.println(distanceTable);
    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      computeDistanceTree(graph, distanceTable, spanningTree);
      spanningTree.add(welcomeNewElement(graph, distanceTable, spanningTree));
      System.out.println(spanningTree);
      System.out.println(distanceTable);
    }

    return distanceTable;
  }

  private void computeDistanceTree(IWeightedGraph graph, DistanceTable distanceTable,
      Set<Integer> spanningTree) {
    for (Integer currentVertex : spanningTree) {
      for (WeightedNode neighbour : graph.getAdjacencyVertex(currentVertex)) {
        if (distanceTable.distance[neighbour.destinationNode] > neighbour.weight) {
          distanceTable.distance[neighbour.destinationNode] = neighbour.weight;
          distanceTable.lastNode[neighbour.destinationNode] = currentVertex;
        }
      }
    }
  }

  private int welcomeNewElement(IWeightedGraph graph, DistanceTable distanceTable,
      Set<Integer> spanningTree) {
    int lowestElement = Integer.MAX_VALUE;
    int newElement = -1;
    for (int j = 0; j < graph.getNumberOfVertices(); j++) {
      if (!spanningTree.contains(j) && lowestElement > distanceTable.distance[j]) {
        lowestElement = distanceTable.distance[j];
        newElement = j;
      }
    }
    return newElement;
  }
}
