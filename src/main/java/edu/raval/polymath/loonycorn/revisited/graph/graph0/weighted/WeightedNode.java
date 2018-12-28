package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

public class WeightedNode implements Comparable<WeightedNode>{
  public final int weight;
  public final int destinationNode;

  public WeightedNode(int destinationNode, int weight) {
    this.destinationNode = destinationNode;
    this.weight = weight;
  }

  @Override
  public int compareTo(WeightedNode o) {
    return Integer.compare(this.weight, o.weight);
  }
}
