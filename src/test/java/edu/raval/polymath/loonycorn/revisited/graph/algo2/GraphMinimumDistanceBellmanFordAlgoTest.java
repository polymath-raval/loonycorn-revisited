package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.A;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.B;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.C;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.D;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.E;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.F;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.setupGraphWithNegativeCycle;
import static edu.raval.polymath.loonycorn.revisited.graph.algo2.Utility.setupGraphWithoutNegativeCycle;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraphType;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class GraphMinimumDistanceBellmanFordAlgoTest {


  IGraphMinimumDistance iGraphMinimumDistance = new GraphMinimumDistanceBellmanFordAlgo();
  IGraph DIRECTED_GRAPH = Utility.setupGraphForDikjstraMinimumDistanceAlgo(IGraphType.DIRECTED);
  IGraph UNDIRECTED_GRAPH = Utility.setupGraphForDikjstraMinimumDistanceAlgo(IGraphType.UNDIRECTED);

  @Test(expected = NegativeCycleExistsException.class)
  public void testGraphWithNegativeCycle() {
    iGraphMinimumDistance.computeDistanceTable(setupGraphWithNegativeCycle(), A);
  }

  @Test
  public void testGraphWithoutNegativeCycle() {
    testSourceTarget(setupGraphWithoutNegativeCycle(), E, A, "EBA", -2);
    testSourceTarget(setupGraphWithoutNegativeCycle(), E, B, "EB", -4);
    testSourceTarget(setupGraphWithoutNegativeCycle(), E, C, "EBAC", 1);
    testSourceTarget(setupGraphWithoutNegativeCycle(), E, D, "EBD", -2);
  }

  @Test
  public void testDirectForE() {
    testSourceTarget(DIRECTED_GRAPH, E, B, "EB", 5);
    testSourceTarget(DIRECTED_GRAPH, E, C, "EBC", 7);
    testSourceTarget(DIRECTED_GRAPH, E, D, "EFD", 9);
    testSourceTarget(DIRECTED_GRAPH, E, F, "EF", 5);
  }

  @Test(expected = NoPathExistsException.class)
  public void testDirectForEToA() {
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

  private void testSourceTarget(IGraph graph, String sourceNode, String targetNode,
      String expectedPath,
      int weight) {
    List<? extends DistanceVertex> path = iGraphMinimumDistance
        .compute(graph, sourceNode, targetNode);
    confirmPath(path, expectedPath);
    confirmWeight(path.get(path.size() - 1), weight);

  }

  private void confirmPath(List<? extends DistanceVertex> path, String expectedPath) {
    String actualPath = path.stream().map(d -> ((DistanceVertex) d).getT().toString())
        .collect(Collectors.joining(""));
    Assert.assertTrue("Expected Path " + expectedPath + " Actual Path " + actualPath,
        StringUtils.equals(actualPath, expectedPath));
  }

  private void confirmWeight(DistanceVertex last, int expectedWeight) {
    Assert
        .assertEquals("Expected Weight " + expectedWeight + " Actual Weight " + last.getDistance(),
            last.getDistance(), expectedWeight);
  }

}