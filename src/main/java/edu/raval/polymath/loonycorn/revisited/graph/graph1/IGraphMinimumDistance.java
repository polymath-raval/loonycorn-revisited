package edu.raval.polymath.loonycorn.revisited.graph.graph1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public interface IGraphMinimumDistance {

  default List<? extends DistanceVertex> compute(IGraph iGraph, String sourceNode, String destinationNode) {
    Map<String, ? extends DistanceVertex> distanceVertexMap = computeDistanceTable(iGraph, sourceNode);
    Stack<DistanceVertex> stack = new Stack<>();
    DistanceVertex distanceVertex = distanceVertexMap.get(destinationNode);
    while (distanceVertex != null &&
        distanceVertex.node != sourceNode &&
        distanceVertex.node != null) {
      stack.add(distanceVertex);
      distanceVertex = distanceVertexMap.get(distanceVertex.lastNode);
    }

    if (distanceVertex != null && distanceVertex.node == sourceNode) {
      stack.add(distanceVertex);
      List<DistanceVertex> result = new ArrayList<>();
      while (!stack.isEmpty()) {
        result.add(stack.pop());
      }
      return result;
    } else {
      throw new NoPathExistsException(
          "No Path Exists between " + sourceNode + " destination node" + destinationNode);
    }

  }

  Map<String, ? extends DistanceVertex> computeDistanceTable(IGraph graph, String sourceNode);
}
