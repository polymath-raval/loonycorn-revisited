package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.Edge;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstTraversal<T extends Comparable<T>> implements IGraphTraversal<T> {


  @Override
  public List<T> traverse(IGraph<T> graph) {
    return null;
  }

  @Override
  public List<T> traverse(IGraph<T> graph, T originNode) {
    Set<T> visited = new HashSet<>();
    List<T> result = new ArrayList<>();
    traverse(graph, visited, result, originNode);
    return result;
  }

  private void traverse(IGraph<T> graph, Set<T> visited, List<T> result, T originNode) {
    if(!visited.contains(originNode)){
      visited.add(originNode);
      for(Edge edge:graph.getEdges(originNode)){
        traverse(graph, visited, result, (T)edge.getDestination());
      }
      result.add(originNode);
    }
  }
}
