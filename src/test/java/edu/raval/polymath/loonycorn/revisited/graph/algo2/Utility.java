package edu.raval.polymath.loonycorn.revisited.graph.algo2;

import edu.raval.polymath.loonycorn.revisited.graph.graph2.AdjacencySetGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraph;
import edu.raval.polymath.loonycorn.revisited.graph.graph2.IGraphType;

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


  static IGraph<String> setupGraphForDikjstraMinimumDistanceAlgo(IGraphType type) {
    IGraph<String> graph = new AdjacencySetGraph(type);
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

  static IGraph<String> setupGraphForGraphTraversal(IGraphType type) {
    IGraph<String> graph = new AdjacencySetGraph(type);
    addEdge(graph, A, B);
    addEdge(graph, A, F);
    addEdge(graph, B, E);
    addEdge(graph, B, C);
    addEdge(graph, C, D);
    addEdge(graph, C, G);
    addEdge(graph, G, F);
    return graph;
  }

  static IGraph<String> setupForestForTopological(IGraphType type) {
    IGraph<String> graph = new AdjacencySetGraph(type);
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

  static IGraph<String> setupGraphForWITHLoop() {
    IGraph<String> graph = new AdjacencySetGraph(IGraphType.DIRECTED);
    addEdge(graph, A, B);
    addEdge(graph, F, A);
    addEdge(graph, B, E);
    addEdge(graph, B, C);
    addEdge(graph, C, D);
    addEdge(graph, C, G);
    addEdge(graph, G, F);
    return graph;
  }

  static IGraph<String> setupGraphWithNegativeCycle() {
    IGraph<String> graph = new AdjacencySetGraph(IGraphType.DIRECTED);

    addEdge(graph, A, B, 2);
    addEdge(graph, A, C, 3);
    addEdge(graph, B, D, 2);
    addEdge(graph, C, E, 6);
    addEdge(graph, E, B, -5);
    addEdge(graph, D, E, 2);
    return graph;
  }

  static IGraph<String> setupGraphWithoutNegativeCycle() {
    IGraph<String> graph = new AdjacencySetGraph(IGraphType.DIRECTED);

    addEdge(graph, B, A, 2);
    addEdge(graph, A, C, 3);
    addEdge(graph, B, D, 2);
    addEdge(graph, C, E, 6);
    addEdge(graph, E, B, -4);
    addEdge(graph, D, E, 2);
    return graph;
  }

  public static void addEdge(IGraph<String> graph, String source, String destination) {
    graph.addEdge(source, destination);
  }

  public static void addEdge(IGraph<String> graph, String source, String destination, int weight) {
    graph.addEdge(source, destination, weight);
  }

  public static void removeEdge(IGraph<String> graph, String source, String destination,
      int weight) {
    graph.removeEdge(source, destination);
  }

  public static void putEmptyNode(IGraph<String> graph, String node) {
    graph.addNode(node);
  }

}
