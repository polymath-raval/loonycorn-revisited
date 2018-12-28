package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0.BinaryHeap1.Type;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxBinaryHeap1Test {

  IBinaryHeap<BigDecimal> priorityQueue;

  @Before
  public void setup() {
    priorityQueue = new BinaryHeap1<>(Type.MAXHEAP);
  }

  @Test(expected = EmptyHeapException.class)
  public void peekEmpty() {
    priorityQueue.peek();
  }

  @Test(expected = EmptyHeapException.class)
  public void popEmpty() {
    priorityQueue.pop();
  }

  @Test
  public void peek() {
    BigDecimal maximum = new BigDecimal(-1);
    for (int i = 0; i < 100000; i++) {
      BigDecimal value = new BigDecimal(Math.random() * 100);
      priorityQueue.put(value);
      maximum = maximum.compareTo(value) < 0 ? value : maximum;
      Assert.assertEquals(maximum, priorityQueue.peek());
      if(i%100 == 0){
        System.out.println("****" + i);
      }
    }
  }

  @Test
  public void pop() {
    for (int i = 0; i < 100000; i++) {
      BigDecimal value = new BigDecimal(Math.random() * 100);
      priorityQueue.put(value);
      if(i%100 == 0){
        System.out.println("****" + i);
      }

    }
    int i=0;
    BigDecimal lastValue = new BigDecimal(100000000);
    while (!priorityQueue.isEmpty()) {
      BigDecimal currentValue = priorityQueue.pop();
      Assert.assertTrue(currentValue.compareTo(lastValue) < 0);
      lastValue = currentValue;
      if(i++%100 == 0){
        System.out.println("****" + i);
      }
    }
  }
}