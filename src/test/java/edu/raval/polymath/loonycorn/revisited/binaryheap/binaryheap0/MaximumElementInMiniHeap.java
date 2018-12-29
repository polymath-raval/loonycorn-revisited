package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0.BinaryHeap2.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class MaximumElementInMiniHeap {

  private final static int size = 10;

  @Test
  public void MINHEAP(){
    Integer max = Integer.MIN_VALUE;
    IBinaryHeap<Integer> binaryHeap = new BinaryHeap2<>(Type.MINHEAP);
    for (int i = 0; i < size; i++) {
      Integer val = (int) (Math.random() * size * 100);
      binaryHeap.put(val);
      max = val > max ? val : max;
    }
    Assert.assertTrue(max == binaryHeap.reverseNaturedElement());
  }

  @Test
  public void MAXHEAP(){
    Integer min = Integer.MAX_VALUE;
    IBinaryHeap<Integer> binaryHeap = new BinaryHeap2<>(Type.MAXHEAP);
    for (int i = 0; i < size; i++) {
      Integer val = (int) (Math.random() * size * 100);
      binaryHeap.put(val);
      min = val < min ? val : min;
    }
    Assert.assertTrue(min == binaryHeap.reverseNaturedElement());
  }

}
