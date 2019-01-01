package edu.raval.polymath.loonycorn.revisited.graph.graph2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.collections4.SetUtils;

public class AdjacencySetGraph<T extends Comparable<T>> implements IGraph<T> {

  private final Map<T, Node<T>> matrix = new HashMap<>();
  private final IGraphType type;

  public AdjacencySetGraph(
      IGraphType type) {
    this.type = type;
  }

  @Override
  public void addNode(T t) {
    if (!matrix.containsKey(t)) {
      matrix.put(t, new Node<T>(t));
    }
  }

  @Override
  public void addEdge(T source, T destination, int weight) {
    addNode(source);
    addNode(destination);
    matrix.get(source).getEdges().add(new Edge<T>(source, destination, weight));
    if (type == IGraphType.UNDIRECTED) {
      matrix.get(destination).getEdges().add(new Edge<T>(destination, source, weight));
    }
  }

  @Override
  public void addEdge(T source, T destination) {
    addEdge(source, destination, 1);
  }

  @Override
  public void removeEdge(T source, T destination) {
    if (matrix.containsKey(source) && matrix.containsKey(destination)) {
      matrix.get(source).getEdges().remove(new Edge<T>(source, destination));
      if (type == IGraphType.UNDIRECTED) {
        matrix.get(destination).getEdges().remove(new Edge<T>(destination, source));
      }
    }
  }

  @Override
  public Set<Edge<T>> getEdges(T source) {
    if (!matrix.containsKey(source)) {
      return SetUtils.emptySet();
    } else {
      return matrix.get(source).getEdges();
    }
  }

  @Override
  public Set<T> getNodes() {
    return new TreeSet<T>(matrix.keySet());
  }

}
