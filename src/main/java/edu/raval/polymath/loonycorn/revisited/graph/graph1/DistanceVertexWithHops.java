package edu.raval.polymath.loonycorn.revisited.graph.graph1;

public class DistanceVertexWithHops extends DistanceVertex{


  public final int numberOfHops;

  public DistanceVertexWithHops(String node, String lastNode, int weight, int numberOfHops) {
    super(node, lastNode, weight);
    this.numberOfHops = numberOfHops;
  }

  public DistanceVertexWithHops(String node) {
    super(node);
    this.numberOfHops = Integer.MAX_VALUE / 2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DistanceVertexWithHops)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    DistanceVertexWithHops that = (DistanceVertexWithHops) o;

    return numberOfHops == that.numberOfHops;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + numberOfHops;
    return result;
  }
}


