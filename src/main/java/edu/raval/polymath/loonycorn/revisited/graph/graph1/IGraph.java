package edu.raval.polymath.loonycorn.revisited.graph.graph1;

import java.util.Set;

public interface IGraph {

  IGraphType getType();

  void addEdge(String sourceNode, EdgeInfo edgeInfo);

  void removeEdge(String sourceNode, EdgeInfo edgeInfo);

  void addEmptyNode(String sourceNode);

  Set<EdgeInfo> getNeighbours(String sourceNode);

  Set<String> getNodes();
}
