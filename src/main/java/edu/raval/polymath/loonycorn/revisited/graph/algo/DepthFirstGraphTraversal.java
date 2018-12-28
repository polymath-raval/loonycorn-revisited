package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphTraversal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstGraphTraversal implements IGraphTraversal {

  private final IGraph graph;
  private final List<String> result = new ArrayList<>();
  private final Set<String> history = new HashSet<>();

  public DepthFirstGraphTraversal() {
    this.graph = null;
  }

  private DepthFirstGraphTraversal(IGraph graph) {
    this.graph = graph;
  }

  @Override
  public List<String> traverse(IGraph graph, String node) {
    DepthFirstGraphTraversal depthFirstGraphTraversal = new DepthFirstGraphTraversal(graph);
    depthFirstGraphTraversal.traverse(node);
    return depthFirstGraphTraversal.result;
  }

  private void traverse(String traversedNode) {
    if (!history.contains(traversedNode)) {
      history.add(traversedNode);
      for(EdgeInfo neighbour: graph.getNeighbours(traversedNode)){
        if(!history.contains(neighbour)){
          traverse(neighbour.destinationNode);
        }
      }
      result.add(traversedNode);
    }
  }
}
