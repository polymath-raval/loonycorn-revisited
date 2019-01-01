package edu.raval.polymath.loonycorn.revisited.graph.graph2;

import java.util.Set;

public interface IGraph<T extends Comparable<T>> {

  void addNode(T t);
  void addEdge(T source, T destination, int weight);
  void addEdge(T source, T destination);
  void removeEdge(T source, T destination);
  Set<Edge<T>> getEdges(T node);
  Set<T> getNodes();
}
