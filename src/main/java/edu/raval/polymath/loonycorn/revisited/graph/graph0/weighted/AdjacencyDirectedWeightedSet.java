package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyDirectedWeightedSet implements IWeightedGraph {
  Map<Integer, Set<WeightedNode>> adjacencySet = new HashMap<>();

  @Override
  public void addEdge(int sourceVertex, WeightedNode destinationVertex) {
    if(sourceVertex == destinationVertex.destinationNode){
      return;
    }
    adjacencySet.putIfAbsent(sourceVertex, new HashSet<>());
    adjacencySet.get(sourceVertex).add(destinationVertex);
  }

  @Override
  public List<WeightedNode> getAdjacencyVertex(int sourceVertex) {
    List<WeightedNode> neighbours = new ArrayList<>(adjacencySet.get(sourceVertex));
    Collections.sort(neighbours);
    return neighbours;
  }

  @Override
  public Integer getNumberOfVertices() {
    return adjacencySet.size();
  }
}
