package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.Edge;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort<T extends Comparable<T>> implements ITopologicalSort<T> {

  public List<T> sort(IGraph<T> graph) {
    Map<T, Integer> indegree = computeInDegree(graph);
    Queue<T> queue = initQueue(new LinkedList<>(), indegree);
    List<T> result = new ArrayList<>();
    while(!queue.isEmpty()){
      T t = queue.poll();
      result.add(t);
      for(Edge<T> edge:graph.getEdges(t)){
        indegree.put(edge.getDestination(), indegree.get(edge.getDestination()) - 1);
        if(indegree.get(edge.getDestination()) == 0){
          queue.offer(edge.getDestination());
        }
      }
    }
    if(result.size() != graph.getNodes().size()){
      throw new LoopExistsException("Loop Exists");
    }
    return result;
  }

  private Map<T, Integer> computeInDegree(IGraph<T> graph) {
    Map<T, Integer> indegree = new HashMap<>();
    for (T t : graph.getNodes()) {
      indegree.putIfAbsent(t, 0);
      for (Edge<T> edge : graph.getEdges(t)) {
        indegree.putIfAbsent(edge.getDestination(), 0);
        indegree.put(edge.getDestination(), indegree.get(edge.getDestination()) + 1);
      }
    }
    return indegree;
  }

  private Queue<T> initQueue(Queue<T> queue, Map<T, Integer> indegree) {
    for (T t : indegree.keySet()) {
      if (indegree.get(t) == 0) {
        queue.offer(t);
      }
    }
    return queue;
  }
}
