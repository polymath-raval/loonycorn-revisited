package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.Edge;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphMinimumDistanceBellmanFordAlgo<T extends Comparable<T>>
    implements IGraphMinimumDistance<T> {

  @Override
  public Map<T, DistanceVertex<T>> computeDistanceTable(IGraph graph, T source) {
    Map<T, DistanceVertex<T>> distanceTable = initDistanceTable(graph, source);
    List<T> nodes = new ArrayList<>(graph.getNodes());
    for (int i = 1; i < graph.getNodes().size(); i++) {
      for (int j = 0; j < nodes.size(); j++) {
        T sourceNode = nodes.get(j);
        Set<Edge<T>> edges = graph.getEdges(sourceNode);
        for (Edge<T> edge : edges) {
          isBetterDistanceFound(graph, distanceTable, sourceNode, edge);
        }
      }
    }

    for (int j = 0; j < nodes.size(); j++) {
      T sourceNode = nodes.get(j);
      Set<Edge<T>> edges = graph.getEdges(sourceNode);
      for (Edge<T> edge : edges) {
        if(isBetterDistanceFound(graph, distanceTable, sourceNode, edge)){
          throw new NegativeCycleExistsException("Negative Cycle");
        }
      }
    }

    return distanceTable;
  }


}
