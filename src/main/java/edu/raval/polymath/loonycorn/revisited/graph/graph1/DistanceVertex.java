package edu.raval.polymath.loonycorn.revisited.graph.graph1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DistanceVertex {
  public final String node;
  public final String lastNode;
  public final int weight;

  public DistanceVertex(String node, String lastNode, int weight) {
    this.node = node;
    this.lastNode = lastNode;
    this.weight = weight;
  }

  public DistanceVertex(String node) {
    this.node = node;
    this.lastNode = null;
    this.weight = Integer.MAX_VALUE / 2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof DistanceVertex)) {
      return false;
    }

    DistanceVertex that = (DistanceVertex) o;

    return new EqualsBuilder()
        .append(weight, that.weight)
        .append(node, that.node)
        .append(lastNode, that.lastNode)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(node)
        .append(lastNode)
        .append(weight)
        .toHashCode();
  }

  @Override
  public String toString() {
    return "DistanceVertex{" +
        "node='" + node + '\'' +
        ", lastNode='" + lastNode + '\'' +
        ", weight=" + weight +
        '}';
  }
}


