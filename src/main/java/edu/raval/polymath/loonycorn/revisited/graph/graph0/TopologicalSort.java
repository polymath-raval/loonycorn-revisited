package edu.raval.polymath.loonycorn.revisited.graph.graph0;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.unweighted.IGraph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

  List<Integer> sort1(IGraph graph) {
    int[] inDegree = computeInDegree(graph);
    List<Integer> result = shuffleAsPerInDegree(graph, inDegree);
    detectLoop(graph, result);
    return result;
  }

  private List<Integer> shuffleAsPerInDegree(IGraph graph, int[] inDegree) {
    List<Integer> result = new ArrayList<>();
    Queue<Integer> queue = initializeQueue(inDegree);

    do{
      Integer node = queue.poll();
      inDegree[node] = -1;
      result.add(node);
      for (Integer neighbour : graph.getAdjacentVertices(node)) {
        inDegree[neighbour]--;
        if(inDegree[neighbour] == 0)
          queue.offer(neighbour);
      }
    }while(!queue.isEmpty());
    return result;
  }

  private void detectLoop(IGraph graph, List<Integer> result) {
    if(result.size() != graph.getNumberOfVertices()){
      throw new RuntimeException("There exists a cycle in the DAG");
    }
  }

  private int[] computeInDegree(IGraph graph) {
    int[] inDegree = new int[graph.getNumberOfVertices()];
    for (int i = 0; i < inDegree.length; i++) {
      graph.getAdjacentVertices(i).forEach(j -> inDegree[j]++);
    }
    return inDegree;
  }

  private Queue<Integer> initializeQueue(int[] inDegree) {
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        inDegree[i] = -1;
        queue.offer(i);
      }
    }
    return queue;
  }



}
