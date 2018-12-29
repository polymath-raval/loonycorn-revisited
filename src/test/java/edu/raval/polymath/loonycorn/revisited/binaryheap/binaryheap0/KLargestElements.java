package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0.BinaryHeap2.Type;
import org.junit.Assert;
import org.junit.Test;

public class KLargestElements {

  @Test
  public void algo() {
    IBinaryHeap<Integer> binaryHeap = new BinaryHeap2<>(Type.MINHEAP);
    int K = 10;

    int size = 100;

    for (int i = 0; i < size; i++) {
      Integer val = (int) (Math.random() * 100);
      if(binaryHeap.size() <= K){
        binaryHeap.put(val);
      }else if (binaryHeap.size() == K && val.compareTo(binaryHeap.peek()) > 0) {
        binaryHeap.pop();
        binaryHeap.put(val);
      }
    }


    for (int i = 0; i < 5; i++) {
      Integer val = 1000 + (int) (Math.random() *  100);
      if(binaryHeap.size() <= K){
        binaryHeap.put(val);
      }else if (binaryHeap.size() >= K && val.compareTo(binaryHeap.peek()) > 0) {
        binaryHeap.pop();
        binaryHeap.put(val);
      }
    }

    int countForValuesGreaterThan1000 = 0;
    while (!binaryHeap.isEmpty()) {
      countForValuesGreaterThan1000 =
          binaryHeap.pop() > 1000 ? countForValuesGreaterThan1000 + 1
              : countForValuesGreaterThan1000;
    }

    Assert.assertEquals(5, countForValuesGreaterThan1000 );
  }
}
