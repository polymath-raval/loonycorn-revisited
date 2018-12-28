package edu.raval.polymath.loonycorn.revisited.graph.graph1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EdgeInfo implements Comparable<EdgeInfo>{
  public final String sourceNode;
  public final int weight;
  public final String destinationNode;

  public EdgeInfo(String sourceNode, String destinationNode, int weight) {
    this.sourceNode =sourceNode;
    this.weight = weight;
    this.destinationNode = destinationNode;
  }

  public EdgeInfo(String sourceNode, String destinationNode) {
    this.sourceNode = sourceNode;
    this.weight = 1;
    this.destinationNode = destinationNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EdgeInfo)) {
      return false;
    }

    EdgeInfo edgeInfo = (EdgeInfo) o;

    return new EqualsBuilder()
        .append(sourceNode, edgeInfo.sourceNode)
        .append(destinationNode, edgeInfo.destinationNode)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(sourceNode)
        .append(destinationNode)
        .toHashCode();
  }

  @Override
  public int compareTo(EdgeInfo o) {
    return this.destinationNode.compareTo(o.destinationNode);
  }

  @Override
  public String toString() {
    return "EdgeInfo{" +
        "sourceNode='" + sourceNode + '\'' +
        ", weight=" + weight +
        ", destinationNode='" + destinationNode + '\'' +
        '}';
  }
}
