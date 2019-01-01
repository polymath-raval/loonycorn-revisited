package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.A;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.B;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.C;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.D;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.E;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.F;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.G;
import static java.util.Arrays.asList;
import static org.apache.commons.collections4.ListUtils.isEqualList;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraphType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepthFirstGraphTraversalTest {

  IGraph UNDIRECTED;
  IGraph DIRECTED;
  IGraphTraversal traversal;

  @Before
  public void setup() throws Exception {
    UNDIRECTED = Utility.setupGraphForGraphTraversal(IGraphType.UNDIRECTED);
    DIRECTED = Utility.setupGraphForGraphTraversal(IGraphType.DIRECTED);
    traversal = new DepthFirstTraversal();
  }

  @Test
  public void traverseWithA() {
    Assert.assertTrue(isEqualList(asList(D, F, G, C, E, B, A),
        traversal.traverse(UNDIRECTED, A)));
    Assert.assertTrue(isEqualList(asList(D, F, G, C, E, B, A),
        traversal.traverse(DIRECTED, A)));
  }

  @Test
  public void traverseWithB() {
    Assert.assertTrue(isEqualList(asList(D, C, G, F, A, E, B),
        traversal.traverse(UNDIRECTED, B)));
    Assert.assertTrue(isEqualList(asList(D, F, G, C, E, B),
        traversal.traverse(DIRECTED, B)));
  }

  @Test
  public void traverseWithC() {
    Assert.assertTrue(isEqualList(asList(G, F, A, E, B, D, C),
        traversal.traverse(UNDIRECTED, C)));
    Assert.assertTrue(isEqualList(asList(D, F, G, C),
        traversal.traverse(DIRECTED, C)));
  }

  @Test
  public void traverseWithD() {
    Assert.assertTrue(isEqualList(asList(G, F, A, E, B, C, D),
        traversal.traverse(UNDIRECTED, D)));
    Assert.assertTrue(isEqualList(asList(D),
        traversal.traverse(DIRECTED, D)));

  }

  @Test
  public void traverseWithE() {
    Assert.assertTrue(isEqualList(asList(D, C, G, F, A, B, E),
        traversal.traverse(UNDIRECTED, E)));
    Assert.assertTrue(isEqualList(asList(E),
        traversal.traverse(DIRECTED, E)));
  }

  @Test
  public void traverseWithF() {
    Assert.assertTrue(isEqualList(asList(D, G, C, E, B, A, F),
        traversal.traverse(UNDIRECTED, F)));
    Assert.assertTrue(isEqualList(asList(F),
        traversal.traverse(DIRECTED, F)));
  }

  @Test
  public void traverseWithG() {
    Assert.assertTrue(isEqualList(asList(F, A, E, B, D, C, G),
        traversal.traverse(UNDIRECTED, G)));
    Assert.assertTrue(isEqualList(asList(F, G),
        traversal.traverse(DIRECTED, G)));
  }
}