package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.DistanceVertexWithHops;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphMinimumDistance;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphMinimumDistanceWithNumberOfVerticesDijkstraAlgo implements IGraphMinimumDistance {

  @Override
  public Map<String, DistanceVertexWithHops> computeDistanceTable(IGraph graph, String sourceNode) {
    Map<String, DistanceVertexWithHops> distanceVertexMap = initDistanceTable(graph, sourceNode);
    Queue<DistanceVertexWithHops> traversalQueue = initPriorityQueue(
        distanceVertexMap.get(sourceNode));
    while (!traversalQueue.isEmpty()) {
      DistanceVertexWithHops currentDistanceVertex = traversalQueue.poll();
      for (EdgeInfo edge : graph.getNeighbours(currentDistanceVertex.node)) {
        String neighbour = edge.destinationNode;
        Integer currentWeight = distanceVertexMap.get(neighbour).weight;
        Integer offeredWeight = currentDistanceVertex.weight + edge.weight;
        Integer currentHops = distanceVertexMap.get(neighbour).numberOfHops;
        Integer offeredHops = currentDistanceVertex.numberOfHops + 1;

        if (currentWeight > offeredWeight ||
            (currentWeight == offeredWeight && currentHops > offeredHops)) {
          DistanceVertexWithHops neighbourDistanceVertex =
              new DistanceVertexWithHops(neighbour, currentDistanceVertex.node, offeredWeight,
                  offeredHops);

          traversalQueue.remove(distanceVertexMap.get(neighbour));
          distanceVertexMap.put(neighbour, neighbourDistanceVertex);
          traversalQueue.offer(neighbourDistanceVertex);

        }
      }
    }

    return distanceVertexMap;
  }

  private Map<String, DistanceVertexWithHops> initDistanceTable(IGraph graph, String sourceNode) {
    Map<String, DistanceVertexWithHops> distanceTable = new HashMap<>();
    for (String node : graph.getNodes()) {
      distanceTable.put(node, new DistanceVertexWithHops(node));
    }
    distanceTable.put(sourceNode, new DistanceVertexWithHops(sourceNode, sourceNode, 0, 0));
    return distanceTable;
  }

  private Queue<DistanceVertexWithHops> initPriorityQueue(DistanceVertexWithHops source) {
    Queue<DistanceVertexWithHops> queue = new PriorityQueue<>(
        new Comparator<DistanceVertexWithHops>() {
          @Override
          public int compare(DistanceVertexWithHops o1, DistanceVertexWithHops o2) {
            if(Integer.compare(o1.weight, o2.weight) == 0){
              return Integer.compare(o1.numberOfHops, o2.numberOfHops);
            }
            return Integer.compare(o1.weight, o2.weight);
          }
        });
    queue.offer(source);
    return queue;
  }
}
