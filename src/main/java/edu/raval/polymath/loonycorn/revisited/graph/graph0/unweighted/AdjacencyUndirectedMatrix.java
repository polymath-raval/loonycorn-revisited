package edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AdjacencyUndirectedMatrix implements IGraph {
  private final boolean[][] matrix;

  public AdjacencyUndirectedMatrix(int numberOfVertices){
    matrix = new boolean[numberOfVertices][numberOfVertices];
  }

  public void addEdge(int sourceVertex, int destinationVertex){
    checkVertex(sourceVertex);
    checkVertex(destinationVertex);
    if(sourceVertex == destinationVertex){
      return;
    }
    matrix[sourceVertex][destinationVertex] = true;
    matrix[destinationVertex][sourceVertex] = true;
  }

  public List<Integer> getAdjacentVertices(int vertex){
    checkVertex(vertex);
    List<Integer> neighbours = new ArrayList();
    for(int i = 0; i < matrix[vertex].length; i++){
      if(matrix[vertex][i]){
        neighbours.add(i);
      }
    }
    Collections.sort(neighbours);
    return neighbours;
  }

  private void checkVertex(int vertex){
    if(vertex < 0 || vertex >= matrix.length){
      throw new IllegalArgumentException("Invalid input for vertex "+vertex);
    }
  }

  public Integer getNumberOfVertices(){
    return matrix.length;
  }
}
