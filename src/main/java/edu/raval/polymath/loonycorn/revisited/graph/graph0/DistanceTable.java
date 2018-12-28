package edu.raval.polymath.loonycorn.revisited.graph.graph0;

import org.apache.commons.lang3.StringUtils;

public class DistanceTable {

  public final int[] distance;
  public final int[] lastNode;

  public DistanceTable(int numberOfVertex, int vertex) {
    distance = initialize(numberOfVertex, Integer.MAX_VALUE/2 );
    lastNode = initialize(numberOfVertex, -1);
    distance[vertex] = 0;
    lastNode[vertex] = vertex;
  }

  private int[] initialize(int n, int value) {
    int[] init = new int[n];
    for (int i = 0; i < n; i++) {
      init[i] = value;
    }
    return init;
  }

  @Override
  public String toString() {
    String str =
        "**** Node "
        + "**** Distance "
            + "**** Last Node ";
    for(int i=0;i<distance.length;i++){
      String strDistance = "";
      String strLastNode = "";
      if(distance[i] >= Integer.MAX_VALUE/2){
        strDistance = "Infinity";
        strLastNode = "Unreachable";
      }else{
        strDistance = ""+distance[i];
        strLastNode = ""+lastNode[i];
      }

      str +="\n"+String.join(" ",
          StringUtils.leftPad(""+i,9),
          StringUtils.leftPad(strDistance, 13),
          StringUtils.leftPad(strLastNode, 14));

    }
    return str;
  }
}
