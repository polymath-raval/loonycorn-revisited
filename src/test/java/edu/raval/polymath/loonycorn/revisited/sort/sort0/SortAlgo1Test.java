package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import edu.raval.polymath.loonycorn.revisited.tree.tree0.InOrderTraversal;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class SortAlgo1Test {

  @Test
  public void sortAlgo1(){
    sort(new SortAlgo1(), 1000);
  }

  @Test
  public void sortAlgo2(){
    sort(new SortAlgo2(), 1000);
  }


  private void sort(ISort sort, int size) {
    int[] input = initArray(size);
    //System.out.println(Arrays.toString(input));
    sort.sort(input);
    //System.out.println(Arrays.toString(input));
    int last = Integer.MIN_VALUE;
    for(int i:input){
      Assert.assertTrue(last <= i);
      last = i;
    }
  }

  private int[] initArray(int size){
    int[] input = new int[size];
    for (int i = 0; i < input.length; i++) {
      input[i] = (int) (Math.random() * 100_000);
    }
    return input;
  }
}