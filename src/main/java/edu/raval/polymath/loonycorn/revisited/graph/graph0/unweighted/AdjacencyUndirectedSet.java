package edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class AdjacencyUndirectedSet implements IGraph {
  private final Map<Integer, Set<Integer>> adjacencyMap = new HashMap();

  public void addEdge(int sourceVertex, int destinationVertex){
    if(sourceVertex == destinationVertex){
      return;
    }
    addDirectedEdge(sourceVertex, destinationVertex);
    addDirectedEdge(destinationVertex, sourceVertex);
  }

  private void addDirectedEdge(int sourceVertex, int destinationVertex){
    if(! adjacencyMap.containsKey(sourceVertex)){
      adjacencyMap.put(sourceVertex, new HashSet<>());
    }
    adjacencyMap.get(sourceVertex).add(destinationVertex);
  }

  public List<Integer> getAdjacentVertices(int vertex){
    Set<Integer> neighbours = adjacencyMap.getOrDefault(vertex, new HashSet<>());
    List<Integer> returnList = new ArrayList<>(neighbours);
    Collections.sort(returnList);
    return returnList;
  }

  public Integer getNumberOfVertices(){
    return adjacencyMap.size();
  }

}
