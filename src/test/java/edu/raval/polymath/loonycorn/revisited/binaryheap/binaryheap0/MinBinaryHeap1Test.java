package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0.BinaryHeap1.Type;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinBinaryHeap1Test {

  IBinaryHeap<BigDecimal> priorityQueue;

  @Before
  public void setup() {
    priorityQueue = new BinaryHeap1<>(Type.MINHEAP);
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
    BigDecimal minimum = new BigDecimal(100000);
    for (int i = 0; i < 500000; i++) {
      BigDecimal value = new BigDecimal(Math.random() * 100);
      priorityQueue.put(value);
      minimum = minimum.compareTo(value) > 0 ? value : minimum;
      Assert.assertEquals(minimum, priorityQueue.peek());
    }
  }

  @Test
  public void pop() {
    for (int i = 0; i < 500000; i++) {
      BigDecimal value = new BigDecimal(Math.random() * 100);
      priorityQueue.put(value);
    }
    BigDecimal lastValue = new BigDecimal(-1);
    while (!priorityQueue.isEmpty()) {
      BigDecimal currentValue = priorityQueue.pop();
      Assert.assertTrue(currentValue.compareTo(lastValue) >= 0);
      lastValue = currentValue;
    }
  }
}