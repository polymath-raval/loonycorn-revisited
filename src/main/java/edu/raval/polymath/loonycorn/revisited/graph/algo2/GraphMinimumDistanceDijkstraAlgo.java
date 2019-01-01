package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.Edge;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphMinimumDistanceDijkstraAlgo<T extends Comparable<T>> implements
    IGraphMinimumDistance<T> {

  public Map<T, DistanceVertex<T>> computeDistanceTable(IGraph graph, T source) {
    Map<T, DistanceVertex<T>> distanceTable = initDistanceTable(graph, source);
    Queue<DistanceVertex<T>> queue = initQueue(distanceTable.get(source));
    while (!queue.isEmpty()) {
      DistanceVertex<T> distanceVertex = queue.poll();
      Set<Edge<T>> edges = graph.getEdges(distanceVertex.getT());
      for (Edge<T> edge : edges) {
        if(isBetterDistanceFound(graph, distanceTable, distanceVertex.getT(), edge)){
          queue.offer(distanceTable.get(edge.getDestination()));
        }
      }
    }
    return distanceTable;

  }

  private Queue<DistanceVertex<T>> initQueue(DistanceVertex<T> distanceVertex) {
    Queue<DistanceVertex<T>> queue = new PriorityQueue<>(new Comparator<DistanceVertex<T>>() {
      @Override
      public int compare(DistanceVertex<T> o1, DistanceVertex<T> o2) {
        return Integer.compare(o1.getDistance(), o2.getDistance());
      }
    });
    queue.offer(distanceVertex);
    return queue;
  }


}
