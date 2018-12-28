package edu.raval.polymath.loonycorn.revisited.graph.algo;

import edu.raval.polymath.loonycorn.revisited.graph.graph1.EdgeInfo;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph1.IGraphType;

public class Utility {

  public static final String A = "A";
  public static final String B = "B";
  public static final String C = "C";
  public static final String D = "D";
  public static final String E = "E";
  public static final String F = "F";
  public static final String G = "G";
  public static final String H = "H";
  public static final String I = "I";

  public static final String X = "X";
  public static final String Y = "Y";
  public static final String Z = "Z";
  public static final String P = "P";


  static IGraph setupGraphForDikjstraMinimumDistanceAlgo(IGraphType type){
    IGraph graph = new AdjacencySetGraph(type);
    addEdge(graph, A, B, 3);
    addEdge(graph, A, E, 5);
    addEdge(graph, A, C, 15);
    addEdge(graph, E, B, 5);
    addEdge(graph, E, F, 5);
    addEdge(graph, E, D, 11);
    addEdge(graph, B, C, 2);
    addEdge(graph, B, F, 8);
    addEdge(graph, C, F, 9);
    addEdge(graph, F, D, 4);
    return graph;
  }

  static IGraph setupGraphForGraphTraversal(IGraphType type) {
    IGraph graph = new AdjacencySetGraph(type);
    addEdge(graph, A, B);
    addEdge(graph, A, F);
    addEdge(graph, B, E);
    addEdge(graph, B, C);
    addEdge(graph, C, D);
    addEdge(graph, C, G);
    addEdge(graph, G, F);
    return graph;
  }

  static IGraph setupForestForTopological(IGraphType type) {
    IGraph graph = new AdjacencySetGraph(type);
    addEdge(graph, A, B);
    addEdge(graph, A, F);
    addEdge(graph, B, E);
    addEdge(graph, B, C);
    addEdge(graph, C, D);
    addEdge(graph, C, G);
    addEdge(graph, G, F);

    addEdge(graph, X, Y);
    addEdge(graph, Y, Z);
    addEdge(graph, Y, P);
    addEdge(graph, Z, P);



    return graph;
  }

  static IGraph setupGraphForWITHLoop() {
    IGraph graph = new AdjacencySetGraph(IGraphType.DIRECTED);
    addEdge(graph, A, B);
    addEdge(graph, F, A);
    addEdge(graph, B, E);
    addEdge(graph, B, C);
    addEdge(graph, C, D);
    addEdge(graph, C, G);
    addEdge(graph, G, F);
    return graph;
  }

  static IGraph setupGraphWithNegativeCycle(){
    IGraph graph = new AdjacencySetGraph(IGraphType.DIRECTED);

    addEdge(graph, A, B, 2);
    addEdge(graph, A, C, 3);
    addEdge(graph, B, D, 2);
    addEdge(graph, C, E, 6);
    addEdge(graph, E, B, -5);
    addEdge(graph, D, E, 2);
    return graph;
  }

  static IGraph setupGraphWithoutNegativeCycle(){
    IGraph graph = new AdjacencySetGraph(IGraphType.DIRECTED);

    addEdge(graph, B, A, 2);
    addEdge(graph, A, C, 3);
    addEdge(graph, B, D, 2);
    addEdge(graph, C, E, 6);
    addEdge(graph, E, B, -4);
    addEdge(graph, D, E, 2);
    return graph;
  }

  public static void addEdge(IGraph graph, String source, String destination){
    graph.addEdge(source, new EdgeInfo(source, destination));
  }

  public static void addEdge(IGraph graph, String source, String destination, int weight){
    graph.addEdge(source, new EdgeInfo(source, destination, weight));
  }

  public static void removeEdge(IGraph graph, String source, String destination, int weight){
    graph.removeEdge(source, new EdgeInfo(source, destination, weight));
  }

  public static void putEmptyNode(IGraph graph, String node){
    graph.addEmptyNode(node);
  }

}
