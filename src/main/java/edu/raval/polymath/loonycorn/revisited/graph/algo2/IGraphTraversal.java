package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.List;

public interface IGraphTraversal<T extends Comparable<T>> {
  List<T> traverse(IGraph<T> graph);
  List<T> traverse(IGraph<T> graph, T originNode);
}
