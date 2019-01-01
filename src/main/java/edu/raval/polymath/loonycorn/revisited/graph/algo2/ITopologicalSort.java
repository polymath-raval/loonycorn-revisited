package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import java.util.List;

public interface ITopologicalSort<T extends Comparable<T>> {
  List<T> sort(IGraph<T> graph);
}
