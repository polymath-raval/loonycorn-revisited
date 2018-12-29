package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

public interface IBinaryHeap<T extends Comparable<T>> {

  void put(T node);
  T peek();
  T pop();
  boolean isEmpty();
  T reverseNaturedElement();
  int size();
}
