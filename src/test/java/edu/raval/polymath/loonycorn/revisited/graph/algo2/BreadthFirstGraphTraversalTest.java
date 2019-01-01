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

public class BreadthFirstGraphTraversalTest {

  IGraph UNDIRECTED;
  IGraph DIRECTED;
  IGraphTraversal traversal;

  @Before
  public void setup() throws Exception {
    UNDIRECTED = Utility.setupGraphForGraphTraversal(IGraphType.UNDIRECTED);
    DIRECTED = Utility.setupGraphForGraphTraversal(IGraphType.DIRECTED);
    traversal = new BreadthFirstTraversal();
  }


  @Test
  public void traverseWithA() {
    Assert.assertTrue(isEqualList(asList(A, B, F, C, E, G, D),
        traversal.traverse(UNDIRECTED, A)));
    Assert.assertTrue(isEqualList(asList(A, B, F, C, E, D, G),
        traversal.traverse(DIRECTED, A)));
  }

  @Test
  public void traverseWithB() {
    Assert.assertTrue(isEqualList(asList(B, A, C, E, F, D, G),
        traversal.traverse(UNDIRECTED, B)));
    Assert.assertTrue(isEqualList(asList(B, C, E, D, G, F),
        traversal.traverse(DIRECTED, B)));
  }

  @Test
  public void traverseWithC() {
    Assert.assertTrue(isEqualList(asList(C, B, D, G, A, E, F),
        traversal.traverse(UNDIRECTED, C)));
    Assert.assertTrue(isEqualList(asList(C, D, G, F),
        traversal.traverse(DIRECTED, C)));
  }

  @Test
  public void traverseWithD() {
    Assert.assertTrue(isEqualList(asList(D, C, B, G, A, E, F),
        traversal.traverse(UNDIRECTED, D)));
    Assert.assertTrue(isEqualList(asList(D),
        traversal.traverse(DIRECTED, D)));

  }

  @Test
  public void traverseWithE() {
    Assert.assertTrue(isEqualList(asList(E, B, A, C, F, D, G),
        traversal.traverse(UNDIRECTED, E)));
    Assert.assertTrue(isEqualList(asList(E),
        traversal.traverse(DIRECTED, E)));
  }

  @Test
  public void traverseWithF() {
    Assert.assertTrue(isEqualList(asList(F, A, G, B, C, E, D),
        traversal.traverse(UNDIRECTED, F)));
    Assert.assertTrue(isEqualList(asList(F),
        traversal.traverse(DIRECTED, F)));
  }

  @Test
  public void traverseWithG() {
    Assert.assertTrue(isEqualList(asList(G, C, F, B, D, A, E),
        traversal.traverse(UNDIRECTED, G)));
    Assert.assertTrue(isEqualList(asList(G, F),
        traversal.traverse(DIRECTED, G)));
  }


}