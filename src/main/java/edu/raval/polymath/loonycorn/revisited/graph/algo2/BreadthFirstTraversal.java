package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.Edge;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstTraversal<T extends Comparable<T>> implements IGraphTraversal<T> {

  @Override
  public List<T> traverse(IGraph<T> graph) {
    Set<T> visited = new HashSet<>();
    List<T> result = new ArrayList<>();
    for (T originNode : graph.getNodes()) {
      traverse(graph, visited, result, originNode);
    }
    return result;
  }

  @Override
  public List<T> traverse(IGraph<T> graph, T originNode) {
    Set<T> visited = new HashSet<>();
    List<T> result = new ArrayList<>();
    traverse(graph, visited, result, originNode);
    return result;
  }

  private void traverse(IGraph<T> graph, Set<T> visited, List<T> result, T originNode) {
    if (!visited.contains(originNode)) {
      Queue<T> traversalQueue = new LinkedList<>();
      traversalQueue.offer(originNode);
      while (!traversalQueue.isEmpty()) {
        T traversedNode = traversalQueue.poll();
        if (!visited.contains(traversedNode)) {
          visited.add(traversedNode);
          result.add(traversedNode);
          for (Edge<T> edge : graph.getEdges(traversedNode)) {
            traversalQueue.add(edge.getDestination());
          }
        }
      }
    }
  }
}
