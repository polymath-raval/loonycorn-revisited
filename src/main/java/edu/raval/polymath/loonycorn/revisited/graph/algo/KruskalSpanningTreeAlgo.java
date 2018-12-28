package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphSpanningTree;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.SpanningTreeException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

public class KruskalSpanningTreeAlgo implements IGraphSpanningTree {

  @Override
  public IGraph compute(IGraph graph) {
    Queue<EdgeInfo> queue = initQueue(graph);
    IGraph result = new AdjacencySetGraph(graph.getType());

    while (!queue.isEmpty() && result.getNodes().size() <= graph.getNodes().size()) {
      EdgeInfo proposed = queue.poll();
      result.addEdge(proposed.sourceNode, proposed);
      if (checkIfCycleExists(result, proposed.sourceNode)) {
        result.removeEdge(proposed.sourceNode, proposed);
      }
    }

    if(result.getNodes().size() != graph.getNodes().size()){
      throw new SpanningTreeException("Spanning Tree does not exist");
    }

    return result;
  }

  boolean checkIfCycleExists(IGraph result, String startNode) {
    Set<String> visited = new HashSet<>();
    Queue<Pair<String,String>> traversal = new LinkedList<>();
    traversal.offer(Pair.of(startNode, null));
    while(!traversal.isEmpty()){
      Pair<String, String> pair = traversal.poll();
      String currentNode = pair.getKey();
      String parentNode = pair.getValue();
      if(visited.contains(currentNode)){
        return true;
      }
      visited.add(currentNode);
      for(EdgeInfo edge : result.getNeighbours(currentNode)){
        if(!StringUtils.equals(edge.destinationNode, parentNode)){
          traversal.offer(Pair.of(edge.destinationNode, edge.sourceNode));
        }
      }
    }
    return false;
  }

  private Queue<EdgeInfo> initQueue (IGraph graph) {
    Set<String> visitedEdge = new HashSet<>();

    Queue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
      @Override
      public int compare(EdgeInfo o1, EdgeInfo o2) {
        return Integer.compare(o1.weight, o2.weight);
      }
    });
    for (String node : graph.getNodes()) {
      for (EdgeInfo edgeInfo : graph.getNeighbours(node)) {
        if(!visitedEdge.contains(edgeInfo.destinationNode + edgeInfo.sourceNode) &&
        !visitedEdge.contains(edgeInfo.sourceNode + edgeInfo.destinationNode))
        queue.offer(edgeInfo);
        visitedEdge.add(edgeInfo.sourceNode + edgeInfo.destinationNode);
      }
    }
    return queue;
  }

}
