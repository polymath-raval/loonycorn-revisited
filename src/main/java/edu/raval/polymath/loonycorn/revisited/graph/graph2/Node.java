package edu.raval.polymath.loonycorn.revisited.graph.graph2;

import java.util.Set;
import java.util.TreeSet;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
  private final T value;
  private final Set<Edge<T>> edges;

  public Node(T value) {
    this.value = value;
    edges = new TreeSet<>();
  }

  public T getValue() {
    return value;
  }

  public Set<Edge<T>> getEdges() {
    return edges;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }

    Node<?> node = (Node<?>) o;

    return value != null ? value.equals(node.value) : node.value == null;
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        ", edges=" + edges +
        '}';
  }

  @Override
  public int compareTo(Node<T> o) {
    return this.getValue().compareTo(o.getValue());
  }
}
