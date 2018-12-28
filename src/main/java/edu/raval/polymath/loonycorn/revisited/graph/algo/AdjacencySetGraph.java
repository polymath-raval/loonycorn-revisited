package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphType;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;

public class AdjacencySetGraph implements IGraph {

  private final IGraphType type;
  private final Map<String, Set<EdgeInfo>> grid = new HashMap<>();
  private final Set<String> nodes = new HashSet<>();

  public AdjacencySetGraph(IGraphType type) {
    this.type = type;
  }

  @Override
  public IGraphType getType() {
    return type;
  }

  @Override
  public void addEdge(String sourceNode, EdgeInfo edgeInfo) {
    nodes.add(sourceNode);
    nodes.add(edgeInfo.destinationNode);
    grid.putIfAbsent(sourceNode, new TreeSet<>());
    grid.get(sourceNode).add(edgeInfo);
    if (getType() == IGraphType.UNDIRECTED) {
      grid.putIfAbsent(edgeInfo.destinationNode, new HashSet<>());
      grid.get(edgeInfo.destinationNode)
          .add(new EdgeInfo(edgeInfo.destinationNode, sourceNode, edgeInfo.weight));
    }
  }

  @Override
  public void removeEdge(String sourceNode, EdgeInfo edgeInfo) {
    CollectionUtils.emptyIfNull(grid.get(sourceNode)).remove(edgeInfo);
    if (getType() == IGraphType.UNDIRECTED) {
      CollectionUtils.emptyIfNull(grid.get(edgeInfo.destinationNode))
          .remove(new EdgeInfo(edgeInfo.destinationNode, sourceNode, edgeInfo.weight));
    }
  }

  @Override
  public void addEmptyNode(String sourceNode) {
    grid.putIfAbsent(sourceNode, new HashSet<>());
    nodes.add(sourceNode);
  }

  @Override
  public Set<EdgeInfo> getNeighbours(String sourceNode) {
    return SetUtils.unmodifiableSet(grid.getOrDefault(sourceNode, Collections.EMPTY_SET));
  }

  @Override
  public Set<String> getNodes() {
    return nodes;
  }
}
