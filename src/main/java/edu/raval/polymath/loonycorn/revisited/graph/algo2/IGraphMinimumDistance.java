package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.Edge;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public interface IGraphMinimumDistance<T extends Comparable<T>> {

  default List<DistanceVertex<T>> compute(IGraph graph, T source, T destination) {
    Map<T, DistanceVertex<T>> distanceTable = computeDistanceTable(graph, source);
    Stack<DistanceVertex<T>> stack = computePathStack(distanceTable, source, destination);
    return inverse(distanceTable, stack, source);
  }

  default Stack<DistanceVertex<T>> computePathStack(Map<T, DistanceVertex<T>> distanceTable,
      T source, T destination) {
    Stack<DistanceVertex<T>> result = new Stack<>();
    T reducedDestination = destination;
    do {
      result.add(distanceTable.get(reducedDestination));
      reducedDestination = (T) distanceTable.get(reducedDestination).getLastNode();
    } while (reducedDestination != null && !source.equals(reducedDestination));
    if (!source.equals(reducedDestination)) {
      throw new NoPathExistsException("No Path Exists");
    }
    return result;
  }

  default List<DistanceVertex<T>> inverse(Map<T, DistanceVertex<T>> distanceTable,
      Stack<DistanceVertex<T>> stack, T source) {
    List<DistanceVertex<T>> result = new ArrayList<>();
    result.add(distanceTable.get(source));
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }

  default Map<T, DistanceVertex<T>> initDistanceTable(IGraph<T> graph, T source) {
    Map<T, DistanceVertex<T>> distanceTable = new HashMap<>();
    for (T t : graph.getNodes()) {
      distanceTable
          .put(t, new DistanceVertex<>(t, null, Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2));
    }
    distanceTable.put(source, new DistanceVertex<>(source, source, 0, 0));
    return distanceTable;
  }

  default boolean isBetterDistanceFound(IGraph<T> graph, Map<T, DistanceVertex<T>> distanceTable,
      T source, Edge<T> edge) {
    T destination = edge.getDestination();
    int currentDistance = distanceTable.get(destination).getDistance();
    int offeredDistance = distanceTable.get(source).getDistance() + edge.getWeight();
    int currentHops = distanceTable.get(destination).getHops();
    int offeredHops = distanceTable.get(source).getHops() + 1;
    if (offeredDistance < currentDistance
        || (offeredDistance == currentDistance && offeredHops < currentHops)
    ) {
      distanceTable.put(destination,
          new DistanceVertex(destination, source, offeredDistance, offeredHops));
      return true;
    }
    return false;
  }

  Map<T, DistanceVertex<T>> computeDistanceTable(IGraph graph, T source);
}
