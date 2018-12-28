package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import java.util.List;

public interface IWeightedGraph {

  enum Implementation {
    MATRIX, SET;
  }

  enum GraphType{
    DIRECTED, UNDIRECTED;
  }

  static IWeightedGraph factory(IWeightedGraph.Implementation implementation, IWeightedGraph.GraphType type,
      int numberOfVertices){
    if(implementation == IWeightedGraph.Implementation.MATRIX && type == IWeightedGraph.GraphType.DIRECTED)
      return new AdjacencyDirectedWeightedMatrix(numberOfVertices);
    else if(implementation == IWeightedGraph.Implementation.MATRIX && type == IWeightedGraph.GraphType.UNDIRECTED)
      return new AdjacencyUndirectedWeightedMatrix(numberOfVertices);
    else if(implementation == IWeightedGraph.Implementation.SET && type == IWeightedGraph.GraphType.DIRECTED)
      return new AdjacencyDirectedWeightedSet();
    else if(implementation == IWeightedGraph.Implementation.SET && type == IWeightedGraph.GraphType.UNDIRECTED)
      return new AdjacencyUndirectedWeightedSet();
    else
      throw new RuntimeException("Unsupported Type");
  }

  void addEdge(int sourceVertex, WeightedNode destinationVertex);
  List<WeightedNode> getAdjacencyVertex(int sourceVertex);
  Integer getNumberOfVertices();
}
