package edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted;

import java.util.List;

public interface IGraph{
  enum Implementation {
      MATRIX, SET;
  }

  enum GraphType{
    DIRECTED, UNDIRECTED;
  }

  static IGraph factory(Implementation implementation, GraphType type,
    int numberOfVertices){
      if(implementation == Implementation.MATRIX && type == GraphType.DIRECTED)
        return new AdjacencyDirectedMatrix(numberOfVertices);
      else if(implementation == Implementation.MATRIX && type == GraphType.UNDIRECTED)
        return new AdjacencyUndirectedMatrix(numberOfVertices);
      else if(implementation == Implementation.SET && type == GraphType.DIRECTED)
        return new AdjacencyDirectedSet();
      else if(implementation == Implementation.SET && type == GraphType.UNDIRECTED)
        return new AdjacencyUndirectedSet();
      else
        throw new RuntimeException("Unsupported Type");
  }

  void addEdge(int sourceVertex, int destinationVertex);
  List<Integer> getAdjacentVertices(int vertex);

  Integer getNumberOfVertices();
}
