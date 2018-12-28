package edu.raval.polymath.loonycorn.revisited.graph.algo;

import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.A;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.B;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.C;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.D;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.E;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.F;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.G;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.P;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.X;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.Y;
import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.Z;
import static java.util.Arrays.asList;
import static org.apache.commons.collections4.ListUtils.isEqualList;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphType;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.ITopologicalSort;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.LoopExistsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopologicalSortTest {

  IGraph WIHTOUT_LOOP;
  IGraph WITH_LOOP;
  IGraph FOREST;
  ITopologicalSort topologicalSort;

  @Before
  public void setup() throws Exception {
    WIHTOUT_LOOP = Utility.setupGraphForGraphTraversal(IGraphType.DIRECTED);
    WITH_LOOP = Utility.setupGraphForWITHLoop();
    FOREST = Utility.setupForestForTopological(IGraphType.DIRECTED);
    topologicalSort = new TopologicalSort();
  }

  @Test
  public void sortWithoutLoop() {
    Assert.assertTrue(isEqualList(asList(A, B, C, E, D, G, F),
        topologicalSort.sort(WIHTOUT_LOOP)));

  }

  @Test(expected = LoopExistsException.class)
  public void sortWithLoop() {
    System.out.println(topologicalSort.sort(WITH_LOOP));
  }

  @Test
  public void sortForForest() {
    Assert.assertTrue(isEqualList(asList(A, X, B, Y, C, E, Z, D, G, P, F),
        topologicalSort.sort(FOREST)));
  }
}