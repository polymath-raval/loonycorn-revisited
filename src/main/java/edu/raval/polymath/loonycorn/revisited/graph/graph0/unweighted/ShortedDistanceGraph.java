package edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.DistanceTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class ShortedDistanceGraph {

  public List<Integer> generatePath(IGraph graph, int sourceVertex, int destinationVertex) {
    DistanceTable distanceTable = compute(graph, sourceVertex);
    if (distanceTable.lastNode[destinationVertex] == -1) {
      return Collections.EMPTY_LIST;
    } else {
      Stack<Integer> result = new Stack<>();
      int currentNode = destinationVertex;
      do {
        result.push(currentNode);
        currentNode = distanceTable.lastNode[currentNode];
      } while (currentNode != sourceVertex && currentNode != -1);
      if (currentNode == -1) {
        return Collections.EMPTY_LIST;
      } else {
        result.push(currentNode);
        List<Integer> returnList = new ArrayList<>();
        while (!result.empty()) {
          returnList.add(result.pop());
        }
        return returnList;
      }
    }
  }

  public DistanceTable compute(IGraph graph, int sourceVertex) {
    DistanceTable distanceTable = new DistanceTable(graph.getNumberOfVertices(), sourceVertex);
    Set<Integer> visited = initVisited(sourceVertex);
    Queue<Integer> queue = initQueue(graph, sourceVertex);
    do {
      int currentVertex = queue.poll();
      if (visited.contains(currentVertex)) {
        continue;
      }
      visited.add(currentVertex);
      for (int neighbourVertex : graph.getAdjacentVertices(currentVertex)) {
        if (distanceTable.distance[neighbourVertex] > (distanceTable.distance[currentVertex] + 1)) {
          distanceTable.distance[neighbourVertex] = distanceTable.distance[currentVertex] + 1;
          distanceTable.lastNode[neighbourVertex] = currentVertex;
        }
        queue.offer(neighbourVertex);
      }
    } while (!queue.isEmpty());

    return distanceTable;

  }

  private Set<Integer> initVisited(int sourceVertex) {
    Set<Integer> visited = new HashSet<>();
    return visited;
  }

  private Queue<Integer> initQueue(IGraph graph, int sourceVertex) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(sourceVertex);
    return queue;
  }


}
