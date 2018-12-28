package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class BinaryHeapSort<T extends Comparable<T>> {

  private int count = 0;
  private T[] base;

  private BinaryHeapSort(T[] _base) {
    this.base = _base;
    count = this.base.length;
  }

  public static <T extends Comparable<T>> void sort(T[] _base) {
    BinaryHeapSort<T> sort = new BinaryHeapSort<T>(_base);
    sort.createHeap();
    sort.sort();
  }

  private void sort(){
    for (int i = 0; i < base.length; i++) {
      T t = pop();
      base[base.length - 1 - i]=t;
    }
  }

  private void createHeap() {
    for (int i = 0; i < count; i++) {
      siftUp(i);
    }
  }

  private T pop() {
    if (count == 0) {
      throw new EmptyHeapException("Empty Queue");
    }
    T first = base[0];
    if (count > 1) {
      base[0] = base[count - 1];
      siftDown(0);
    }
    count--;

    return first;
  }

  private void siftUp(int myIndex) {
    if (myIndex > 0 &&
        swapIfNecessary(getParentIndex(myIndex), myIndex)) {
      siftUp(getParentIndex(myIndex));
    }
  }

  void siftDown(int myIndex) {
    int myLeftChildIndex = getLeftChildIndex(myIndex);
    int myRightChildIndex = getRightChildIndex(myIndex);

    if (myLeftChildIndex != -1 && myRightChildIndex != -1) {
      T myLeftChildValue = getLeftChild(myIndex);
      T myRightChildValue = getRightChild(myIndex);
      if (myLeftChildValue.compareTo(myRightChildValue) < 0
          && swapIfNecessary(myIndex, myLeftChildIndex)) {
        siftDown(myLeftChildIndex);
      } else if (swapIfNecessary(myIndex, myRightChildIndex)) {
        siftDown(myRightChildIndex);
      }
    } else if (myLeftChildIndex != -1 && myRightChildIndex == -1
        && swapIfNecessary(myIndex, myLeftChildIndex)) {
      siftDown(myLeftChildIndex);
    } else if (myLeftChildIndex == -1 && myRightChildIndex != -1
        && swapIfNecessary(myIndex, myRightChildIndex)) {
      siftDown(myRightChildIndex);
    }
  }

  private boolean swapIfNecessary(int idx1, int idx2) {
    T idx1Value = base[idx1];
    if (idx2 != -1) {
      T idx2Value = base[idx2];
      if (idx2Value.compareTo(idx1Value) < 0) {
        base[idx2] = idx1Value;
        base[idx1] = idx2Value;
        return true;
      }
    }
    return false;
  }

  private int getLeftChildIndex(int index) {
    int proposed = (2 * index) + 1;
    return proposed < count ? proposed : -1;
  }

  private int getRightChildIndex(int index) {
    int proposed = (2 * index) + 2;
    return proposed < count ? proposed : -1;
  }

  private T getLeftChild(int index) {
    int leftChildIndex = getLeftChildIndex(index);
    return leftChildIndex != -1 ? base[leftChildIndex] : null;
  }

  private T getRightChild(int index) {
    int rightChildIndex = getRightChildIndex(index);
    return rightChildIndex != -1 ? base[rightChildIndex] : null;
  }


  private int getParentIndex(int index) {
    if (index % 2 == 0) {
      return (index - 2) / 2;
    } else {
      return (index - 1) / 2;
    }
  }


}
