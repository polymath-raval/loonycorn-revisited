package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.DistanceVertex;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphMinimumDistance;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.NegativeCycleExistsException;
import java.util.HashMap;
import java.util.Map;

public class GraphMinimumDistanceBellmanFordAlgo implements IGraphMinimumDistance {

  @Override
  public Map<String, DistanceVertex> computeDistanceTable(IGraph graph, String sourceNode) {
    Map<String, DistanceVertex> distanceVertexMap = initDistanceTable(graph, sourceNode);

    for (int i = 1; i < graph.getNodes().size(); i++) {
      for (String node : graph.getNodes()) {
        for(EdgeInfo edge : graph.getNeighbours(node)){
          int currentWeight = distanceVertexMap.get(edge.destinationNode).weight;
          int offeredWeight = distanceVertexMap.get(node).weight + edge.weight;
          if(currentWeight > offeredWeight){
            distanceVertexMap.put(edge.destinationNode,
                new DistanceVertex(edge.destinationNode, node, offeredWeight));
          }
        }
      }
    }

    for (String node : graph.getNodes()) {
      for(EdgeInfo edge : graph.getNeighbours(node)){
        int currentWeight = distanceVertexMap.get(edge.destinationNode).weight;
        int offeredWeight = distanceVertexMap.get(node).weight + edge.weight;
        if(currentWeight > offeredWeight){
          throw new NegativeCycleExistsException("Negative Cycle");
        }
      }
    }

    return distanceVertexMap;
  }

  private Map<String, DistanceVertex> initDistanceTable(IGraph graph, String sourceNode) {
    Map<String, DistanceVertex> distanceTable = new HashMap<>();
    for (String node : graph.getNodes()) {
      distanceTable.put(node, new DistanceVertex(node));
    }
    distanceTable.put(sourceNode, new DistanceVertex(sourceNode, sourceNode, 0));
    return distanceTable;
  }


}
