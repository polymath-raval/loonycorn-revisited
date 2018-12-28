package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphTraversal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstGraphTraversal implements IGraphTraversal {

  @Override
  public List<String> traverse(IGraph graph, String node) {
    Queue<String> traversalQueue = setupTraversalQueue(node);
    Set<String> history = setupHistory();
    List<String> result = new ArrayList<>();

    while (!traversalQueue.isEmpty()) {
      String traversedNode = traversalQueue.poll();
      if (!history.contains(traversedNode)) {
        history.add(traversedNode);
        result.add(traversedNode);
        graph.getNeighbours(traversedNode);
        for (EdgeInfo edge : graph.getNeighbours(traversedNode)) {
          if (!history.contains(edge.destinationNode)) {
            traversalQueue.offer(edge.destinationNode);
          }
        }
      }
    }

    return result;
  }

  private Set<String> setupHistory() {
    return new HashSet<>();
  }

  private Queue<String> setupTraversalQueue(String node) {
    Queue<String> queue = new LinkedList<>();
    queue.offer(node);
    return queue;
  }
}
