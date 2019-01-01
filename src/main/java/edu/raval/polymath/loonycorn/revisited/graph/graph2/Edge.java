package edu.raval.polymath.loonycorn.revisited.graph.graph2;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

  private final T source;
  private final T destination;
  private final int weight;

  public Edge(T source, T destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }

  public Edge(T source, T destination) {
    this(source, destination, 1);
  }

  public T getSource() {
    return source;
  }

  public T getDestination() {
    return destination;
  }

  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Edge)) {
      return false;
    }

    Edge<?> edge = (Edge<?>) o;

    if (!getSource().equals(edge.getSource())) {
      return false;
    }
    return getDestination().equals(edge.getDestination());
  }

  @Override
  public int hashCode() {
    int result = getSource().hashCode();
    result = 31 * result + getDestination().hashCode();
    return result;
  }

  @Override
  public int compareTo(Edge<T> o) {
    if (this.getWeight() == o.getWeight()) {
      return this.getDestination().compareTo(o.getDestination());
    } else {
      return Integer.compare(this.weight, o.weight);
    }
  }
}
