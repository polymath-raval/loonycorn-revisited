package edu.raval.polymath.loonycorn.revisited.graph.graph0;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Traversal {

  public List<Integer> breadthFirst(IGraph graph) {
    Set<Integer> visitedVertices = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      breadthFirstWithVertex(i, graph, visitedVertices, result);
    }

    return result;
  }

  private void breadthFirstWithVertex(
      int vertex, IGraph graph, Set<Integer> visitedVertices, List<Integer> result) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(vertex);
    do {
      int j = queue.poll();
      if (!visitedVertices.contains(j)) {
        visitedVertices.add(j);
        result.add(j);
        graph.getAdjacentVertices(j).forEach(queue::offer);
      }
    } while (!queue.isEmpty());
  }


  public List<Integer> depthFirst(IGraph graph){
    Set<Integer> visitedVertices = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      depthFirstWithVertex(i, graph, visitedVertices, result);
    }

    return result;
  }

  private void depthFirstWithVertex(
      int vertex, IGraph graph, Set<Integer> visitedVertices, List<Integer> result) {
    if(visitedVertices.contains(vertex)){
      return;
    }
    visitedVertices.add(vertex);
    graph.getAdjacentVertices(vertex).forEach(nVertex -> depthFirstWithVertex(nVertex, graph, visitedVertices, result));
    result.add(vertex);
    return;
  }
}
