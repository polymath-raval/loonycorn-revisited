package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap2<T extends Comparable<T>> implements IBinaryHeap<T> {

  private final Type type;
  private List<T> base;

  public BinaryHeap2(Type t) {
    type = t;
    base = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return base.isEmpty();
  }

  @Override
  public void put(T node) {
    base.add(node);
    siftUp(getParentIndex(base.size() - 1));
  }

  @Override
  public T peek() {
    if (base.size() == 0) {
      throw new EmptyHeapException("Empty Queue");
    }
    return base.get(0);
  }

  @Override
  public T pop() {
    if (base.size() == 0) {
      throw new EmptyHeapException("Empty Queue");
    }
    T first = base.get(0);
    if (base.size() > 1) {
      base.set(0, base.remove(base.size() - 1));
      siftDown(0);
    } else {
      base.clear();
    }
    return first;
  }

  private void siftUp(int myIndex) {
    if (myIndex == -1) {
      return;
    }
    int myLeftChildIndex = getLeftChildIndex(myIndex);
    int myRightChildIndex = getRightChildIndex(myIndex);

    if (myLeftChildIndex != -1 && myRightChildIndex != -1) {
      T myLeftChildValue = getLeftChild(myIndex);
      T myRightChildValue = getRightChild(myIndex);
      if (shouldBeSwaped(myLeftChildValue, myRightChildValue)
          && swapIfNecessary(myIndex,
          myLeftChildIndex)) {
        siftUp(getParentIndex(myIndex));
      } else if (swapIfNecessary(myIndex, myRightChildIndex)) {
        siftUp(getParentIndex(myIndex));
      }
    } else if (myLeftChildIndex != -1
        && myRightChildIndex == -1
        && swapIfNecessary(myIndex, myLeftChildIndex)) {
      siftUp(getParentIndex(myIndex));
    } else if (myLeftChildIndex == -1
        && myRightChildIndex != -1
        && swapIfNecessary(myIndex, myRightChildIndex)) {
      siftUp(getParentIndex(myIndex));
    }
  }

  private void siftDown(int myIndex) {
    int myLeftChildIndex = getLeftChildIndex(myIndex);
    int myRightChildIndex = getRightChildIndex(myIndex);

    if (myLeftChildIndex != -1 && myRightChildIndex != -1) {
      T myLeftChildValue = getLeftChild(myIndex);
      T myRightChildValue = getRightChild(myIndex);
      if (shouldBeSwaped(myLeftChildValue, myRightChildValue)
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

  private boolean swapIfNecessary(int rootIndex, int childIndex) {
    T myValue = base.get(rootIndex);
    if (childIndex != -1) {
      T myLeftChildValue = base.get(childIndex);
      if (shouldBeSwaped(myLeftChildValue, myValue)) {
        base.set(childIndex, myValue);
        base.set(rootIndex, myLeftChildValue);
        return true;
      }
    }
    return false;
  }

  private T getLeftChild(int index) {
    int leftChildIndex = getLeftChildIndex(index);
    return leftChildIndex != -1 ? base.get(getLeftChildIndex(index)) : null;
  }

  private T getRightChild(int index) {
    int rightChildIndex = getRightChildIndex(index);
    return rightChildIndex != -1 ? base.get(getRightChildIndex(index)) : null;
  }

  private T getParent(int index) {
    int parentIndex = getParentIndex(index);
    return parentIndex != -1 ? base.get(getParentIndex(index)) : null;
  }

  private int getLeftChildIndex(int index) {
    int proposed = (2 * index) + 1;
    return proposed < base.size() ? proposed : -1;
  }

  private int getRightChildIndex(int index) {
    int proposed = (2 * index) + 2;
    return proposed < base.size() ? proposed : -1;
  }

  private int getParentIndex(int index) {
    if (index % 2 == 0) {
      return (index - 2) / 2;
    } else {
      return (index - 1) / 2;
    }
  }

  private boolean shouldBeSwaped(T t1, T t2) {
    if (type == Type.MINHEAP) {
      return t1.compareTo(t2) < 0;
    } else {
      return t1.compareTo(t2) > 0;
    }
  }


  public enum Type {
    MINHEAP, MAXHEAP;
  }


}
