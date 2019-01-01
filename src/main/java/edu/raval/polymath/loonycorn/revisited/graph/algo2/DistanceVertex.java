package edu.raval.polymath.loonycorn.revisited.graph.algo2;

public class DistanceVertex<T extends Comparable<T>> {
  private final T t;
  private final T lastNode;
  private final int distance;
  private final int hops;

  public DistanceVertex(T t, T lastNode, int distance, int hops) {
    this.t = t;
    this.lastNode = lastNode;
    this.distance = distance;
    this.hops = hops;
  }

  public int getHops() {
    return hops;
  }

  public T getT() {
    return t;
  }

  public T getLastNode() {
    return lastNode;
  }

  public int getDistance() {
    return distance;
  }

  @Override
  public String toString() {
    return "DistanceVertex{" +
        "t=" + t +
        ", lastNode=" + lastNode +
        ", distance=" + distance +
        ", hops=" + hops +
        '}';
  }
}
