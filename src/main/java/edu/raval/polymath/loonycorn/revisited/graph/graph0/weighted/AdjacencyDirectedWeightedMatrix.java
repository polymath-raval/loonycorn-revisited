package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyDirectedWeightedMatrix implements IWeightedGraph {

  private final boolean[][] presentMatrix;
  private final int[][] weightMatrix;

  public AdjacencyDirectedWeightedMatrix(int numberOfVertices) {
    this.presentMatrix = new boolean[numberOfVertices][numberOfVertices];
    this.weightMatrix = initWeightMatrix(numberOfVertices);
  }

  private int[][] initWeightMatrix(int numberOfVertices) {
    int[][] _weightMatrix = new int[numberOfVertices][numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      for (int j = 0; j < numberOfVertices; j++) {
        _weightMatrix[i][j] = Integer.MAX_VALUE;
      }
    }
    return _weightMatrix;
  }

  @Override
  public void addEdge(int sourceVertex, WeightedNode destinationVertex) {
    presentMatrix[sourceVertex][destinationVertex.destinationNode] = true;
    weightMatrix[sourceVertex][destinationVertex.destinationNode] = destinationVertex.weight;
  }

  @Override
  public List<WeightedNode> getAdjacencyVertex(int sourceVertex) {
    List<WeightedNode> neighbours = new ArrayList<>();

    for (int i = 0; i < presentMatrix[sourceVertex].length; i++) {
      if (presentMatrix[sourceVertex][i]) {
        neighbours.add(new WeightedNode(i, weightMatrix[sourceVertex][i]));
      }
    }
    Collections.sort(neighbours);
    return neighbours;
  }

  @Override
  public Integer getNumberOfVertices() {
    return presentMatrix.length;
  }
}
