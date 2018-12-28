package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BinaryHeapSortTest {
  private final static int size = 500_000 * 10;

  private Integer[] createData(){
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add((int) (Math.random() * size) );
    }
    return list.toArray(new Integer[size]);
  }

  @Test
  public void sort() throws Exception{
    Thread.sleep(20*1000);


    Integer[] input = createData();
    BinaryHeapSort.sort(input);
    Integer last = Integer.MAX_VALUE;
    for(Integer val : input){
      Assert.assertTrue(last >= val);
      last = val;
    }
    //System.out.println(Arrays.toString(input));

  }
}

