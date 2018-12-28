package edu.raval.polymath.loonycorn.revisited.graph.usecase;

import edu.raval.polymath.loonycorn.revisited.graph.algo.AdjacencySetGraph;
import edu.raval.polymath.loonycorn.revisited.graph.algo.TopologicalSort;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphType;
import org.junit.Before;
import org.junit.Test;

import static edu.raval.polymath.loonycorn.revisited.graph.algo.Utility.*;
public class CourseSchedule {
  private static final String CS_101 = "CS_101";
  private static final String CS_102 = "CS_102";
  private static final String CS_103 = "CS_103";
  private static final String CS_104 = "CS_104";
  private static final String CS_105 = "CS_105";
  private static final String CS_106 = "CS_106";
  private static final String CS_107 = "CS_107";

  IGraph graph;

  @Before
  public void setup(){
    graph = new AdjacencySetGraph(IGraphType.DIRECTED);
    putEmptyNode(graph, CS_101);
    putEmptyNode(graph, CS_102);
    putEmptyNode(graph, CS_103);
    putEmptyNode(graph, CS_104);
    putEmptyNode(graph, CS_105);
    putEmptyNode(graph, CS_106);
    putEmptyNode(graph, CS_107);

    addEdge(graph, CS_101, CS_102);
    addEdge(graph, CS_101, CS_103);
    addEdge(graph, CS_103, CS_105);
    addEdge(graph, CS_104, CS_105);
    addEdge(graph, CS_105, CS_107);



  }

  @Test
  public void createSchedule(){
    System.out.println(new TopologicalSort().sort(graph));
  }

}
