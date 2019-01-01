package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.A;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.B;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.C;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.D;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.E;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.F;

import edu.raval.polymath.loonycorn.revisited.graph.algo2.GraphMinimumDistanceDijkstraAlgo;
import edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility;
import edu.raval.polymath.loonycorn.revisited.graph.algo2.DistanceVertex;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.algo2.IGraphMinimumDistance;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraphType;
import edu.raval.polymath.loonycorn.revisited.graph.algo2.NoPathExistsException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class GraphMinimumDistanceDijkstraAlgoTest {

  IGraphMinimumDistance iGraphMinimumDistance = new GraphMinimumDistanceDijkstraAlgo();
  IGraph DIRECTED_GRAPH = Utility.setupGraphForDikjstraMinimumDistanceAlgo(IGraphType.DIRECTED);
  IGraph UNDIRECTED_GRAPH = Utility.setupGraphForDikjstraMinimumDistanceAlgo(IGraphType.UNDIRECTED);

  @Test
  public void testDirectForE() {
    testSourceTarget(DIRECTED_GRAPH, E, B, "EB", 5);
    testSourceTarget(DIRECTED_GRAPH, E, C, "EBC", 7);
    testSourceTarget(DIRECTED_GRAPH, E, D, "EFD", 9);
    testSourceTarget(DIRECTED_GRAPH, E, F, "EF", 5);
  }

  @Test(expected = NoPathExistsException.class)
  public void testDirectForEToA(){
    testSourceTarget(DIRECTED_GRAPH, E, A, "", -1);
  }

  @Test
  public void testUnDirectForE() {
    testSourceTarget(UNDIRECTED_GRAPH, E, B, "EB", 5);
    testSourceTarget(UNDIRECTED_GRAPH, E, C, "EBC", 7);
    testSourceTarget(UNDIRECTED_GRAPH, E, D, "EFD", 9);
    testSourceTarget(UNDIRECTED_GRAPH, E, F, "EF", 5);
    testSourceTarget(UNDIRECTED_GRAPH, E, A, "EA", 5);

  }


  @Test
  public void testDirect() {
    testSourceTarget(DIRECTED_GRAPH, A, B, "AB", 3);
    testSourceTarget(DIRECTED_GRAPH, A, C, "ABC", 5);
    testSourceTarget(DIRECTED_GRAPH, A, D, "AEFD", 14);
    testSourceTarget(DIRECTED_GRAPH, A, E, "AE", 5);
    testSourceTarget(DIRECTED_GRAPH, A, F, "AEF", 10);
  }

  @Test
  public void testUnDirect() {
    testSourceTarget(UNDIRECTED_GRAPH, A, B, "AB", 3);
    testSourceTarget(UNDIRECTED_GRAPH, A, C, "ABC", 5);
    testSourceTarget(UNDIRECTED_GRAPH, A, D, "AEFD", 14);
    testSourceTarget(UNDIRECTED_GRAPH, A, E, "AE", 5);
    testSourceTarget(UNDIRECTED_GRAPH, A, F, "AEF", 10);
  }

  private void testSourceTarget(IGraph graph, String sourceNode, String targetNode, String expectedPath,
      int weight) {
    List<? extends DistanceVertex> path = iGraphMinimumDistance.compute(graph, sourceNode, targetNode);
    confirmPath(path, expectedPath);
    confirmWeight(path.get(path.size() - 1), weight);

  }

  private void confirmPath(List<? extends DistanceVertex> path, String expectedPath) {
    String actualPath = path.stream().map(d -> ((DistanceVertex) d).getT().toString()).collect(Collectors.joining(""));
    Assert.assertTrue("Expected Path " + expectedPath + " Actual Path " + actualPath,
        StringUtils.equals(actualPath, expectedPath));
  }

  private void confirmWeight(DistanceVertex last, int expectedWeight) {
    Assert.assertEquals("Expected Weight " + expectedWeight + " Actual Weight " + last.getDistance(),
        last.getDistance(), expectedWeight);
  }
}