package edu.raval.polymath.loonycorn.revisited.graph.graph0.weighted;

import edu.raval.polymath.loonycorn.revisited.graph.graph0.DistanceTable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortedDistanceWeightedGraph {

  public DistanceTable computeDijkstraDistanceTable(IWeightedGraph graph, int sourceVertex) {
    DistanceTable distanceTable = new DistanceTable(graph.getNumberOfVertices(), sourceVertex);
    Queue<Integer> queue = initQueue(sourceVertex);
    do {
      int currentNode = queue.poll();
      for (WeightedNode neighbour : graph.getAdjacencyVertex(currentNode)) {
        if (distanceTable.distance[neighbour.destinationNode] >
            distanceTable.distance[currentNode] + neighbour.weight) {
          distanceTable.distance[neighbour.destinationNode] =
              distanceTable.distance[currentNode] + neighbour.weight;
          distanceTable.lastNode[neighbour.destinationNode] = currentNode;
          queue.offer(neighbour.destinationNode);
        }
      }
    } while (!queue.isEmpty());
    return distanceTable;
  }

  public Queue<Integer> initQueue(int sourceVertex) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(sourceVertex);
    return queue;
  }

  public DistanceTable computeBellmanFordDistanceTable(IWeightedGraph graph, int sourceVertex) {
    DistanceTable distanceTable = new DistanceTable(graph.getNumberOfVertices(), sourceVertex);
    System.out.println(distanceTable);

    Set<String> edges = new HashSet<>();
    for (int i = 0; i < graph.getNumberOfVertices(); i++) {
      for (WeightedNode w : graph.getAdjacencyVertex(i)) {
        if (!edges.contains(i + "~" + w.destinationNode + "~" + w.weight)) {
          edges.add(i + "~" + w.destinationNode + "~" + w.weight);
        }
      }
    }
    System.out.println(edges);

    for (int i = 1; i < graph.getNumberOfVertices(); i++) {
      for (String edge : edges) {
        int sourceNode = Integer.parseInt(edge.split("~")[0]);
        int destinationNode = Integer.parseInt(edge.split("~")[1]);
        int weight = Integer.parseInt(edge.split("~")[2]);
        if (distanceTable.distance[destinationNode] >
            distanceTable.distance[sourceNode] + weight) {
          distanceTable.distance[destinationNode] = distanceTable.distance[sourceNode] + weight;
          distanceTable.lastNode[destinationNode] = sourceNode;
        }
        System.out.println("**** " + sourceNode + " ***** " + destinationNode);
        System.out.println(distanceTable);
      }


    }
    for (String edge : edges) {
      int sourceNode = Integer.parseInt(edge.split("~")[0]);
      int destinationNode = Integer.parseInt(edge.split("~")[1]);
      int weight = Integer.parseInt(edge.split("~")[2]);
      if (distanceTable.distance[destinationNode] >
          distanceTable.distance[sourceNode] + weight) {
        throw new RuntimeException("There exists a negative cycle");

      }
    }

    return distanceTable;
  }


  public DistanceTable computeBellmanFordDistanceTable1(IWeightedGraph graph, int sourceVertex) {
    DistanceTable distanceTable = new DistanceTable(graph.getNumberOfVertices(), sourceVertex);
    //System.out.println(distanceTable);


    for(int i=1;i<graph.getNumberOfVertices();i++){
      for (int j = 0; j < graph.getNumberOfVertices(); j++) {
        for (WeightedNode neighbour : graph.getAdjacencyVertex(j)) {
          if (distanceTable.distance[neighbour.destinationNode] >
              distanceTable.distance[j] + neighbour.weight) {
            distanceTable.distance[neighbour.destinationNode] =
                distanceTable.distance[j] + neighbour.weight;
            distanceTable.lastNode[neighbour.destinationNode] = j;
            //System.out.println("**** " + j + "" + neighbour.destinationNode);
            //System.out.println(distanceTable);
          }
        }
      }
    }

    for (int j = 0; j < graph.getNumberOfVertices(); j++) {
      for (WeightedNode neighbour : graph.getAdjacencyVertex(j)) {
        if (distanceTable.distance[neighbour.destinationNode] >
            distanceTable.distance[j] + neighbour.weight) {
          throw new RuntimeException("There exists a negative cycle");
        }
      }
    }

    return distanceTable;
  }
}
