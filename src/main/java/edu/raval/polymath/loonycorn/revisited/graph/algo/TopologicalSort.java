package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.ITopologicalSort;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.LoopExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class TopologicalSort implements ITopologicalSort {

  public List<String> sort(IGraph graph) {
    Map<String, AtomicInteger> inDegree = computeInDegree(graph);
    Queue<String> traversalQueue = initQueue(inDegree);
    List<String> result = sort(graph, inDegree, traversalQueue);
    validateIfLoop(result, graph);
    return result;
  }

  private void validateIfLoop(List<String> result, IGraph graph) {
    if (result.size() != graph.getNodes().size()) {
      throw new LoopExistsException("Loop Exists "+result);
    }
  }

  private List<String> sort(IGraph graph, Map<String, AtomicInteger> inDegree,
      Queue<String> traversalQueue) {
    List<String> result = new ArrayList<>();

    while (!traversalQueue.isEmpty()) {
      String node = traversalQueue.poll();
      result.add(node);
      for (EdgeInfo neighbour : graph.getNeighbours(node)) {
        if (inDegree.get(neighbour.destinationNode).decrementAndGet() == 0) {
          traversalQueue.add(neighbour.destinationNode);
        }
      }
    }
    return result;
  }

  private Queue<String> initQueue(Map<String, AtomicInteger> inDegree) {
    Queue<String> queue = new LinkedList<>();
    for (String node : inDegree.keySet()) {
      if (inDegree.get(node).intValue() == 0) {
        queue.offer(node);
      }
    }
    return queue;
  }

  private Map<String, AtomicInteger> computeInDegree(IGraph graph) {
    Map<String, AtomicInteger> inDegree = new HashMap<>();
    for (String node : graph.getNodes()) {
      inDegree.put(node, new AtomicInteger(0));
    }
    for (String node : graph.getNodes()) {
      for (EdgeInfo neighbour : graph.getNeighbours(node)) {
        inDegree.get(neighbour.destinationNode).incrementAndGet();
      }
    }
    return inDegree;
  }
}
