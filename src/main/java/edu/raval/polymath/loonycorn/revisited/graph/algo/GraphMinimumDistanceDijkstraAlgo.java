package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.DistanceVertex;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphMinimumDistance;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphMinimumDistanceDijkstraAlgo implements IGraphMinimumDistance {

  @Override
  public Map<String, DistanceVertex> computeDistanceTable(IGraph graph, String sourceNode) {
    Map<String, DistanceVertex> distanceVertexMap = initDistanceTable(graph, sourceNode);
    Queue<DistanceVertex> traversalQueue = initPriorityQueue(distanceVertexMap.get(sourceNode));
    while (!traversalQueue.isEmpty()) {
      DistanceVertex currentDistanceVertex = traversalQueue.poll();
      for (EdgeInfo edge : graph.getNeighbours(currentDistanceVertex.node)) {
        String neighbour = edge.destinationNode;
        Integer currentWeight = distanceVertexMap.get(neighbour).weight;
        Integer offeredWeight = currentDistanceVertex.weight + edge.weight;
        if (currentWeight > offeredWeight) {
          DistanceVertex neighbourDistanceVertex =
              new DistanceVertex(neighbour, currentDistanceVertex.node, offeredWeight);

          traversalQueue.remove(distanceVertexMap.get(neighbour));
          distanceVertexMap.put(neighbour, neighbourDistanceVertex);
          traversalQueue.offer(neighbourDistanceVertex);

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

  private Queue<DistanceVertex> initPriorityQueue(DistanceVertex source) {
    Queue<DistanceVertex> queue = new PriorityQueue<>(new Comparator<DistanceVertex>() {
      @Override
      public int compare(DistanceVertex o1, DistanceVertex o2) {
        return Integer.compare(o1.weight, o2.weight);
      }
    });
    queue.offer(source);
    return queue;
  }
}
