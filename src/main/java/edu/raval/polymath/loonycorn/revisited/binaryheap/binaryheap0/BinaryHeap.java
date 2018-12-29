package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> implements IBinaryHeap<T> {

  public enum Type{
    MINHEAP, MAXHEAP;
  }

  private final Type type;
  private List<T> base;


  public BinaryHeap(Type t){
    type = t;
    base = new ArrayList<>();
  }

  @Override
  public int size() {
    return base.size();
  }

  @Override
  public T reverseNaturedElement() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return base.isEmpty();
  }

  @Override
  public void put(T node) {
    base.add(node);
    heapify(0);
    //System.out.println(base);
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
      heapify(0);
    } else {
      base.clear();
    }
    //System.out.println(base);
    return first;
  }

  private void heapify(int myIndex) {
    int myLeftChildIndex = getLeftChildIndex(myIndex);
    int myRightChildIndex = getRightChildIndex(myIndex);
    if (myLeftChildIndex != -1) {
      heapify(myLeftChildIndex);
      swapIfNecessary(myIndex, myLeftChildIndex);
    }
    if (myRightChildIndex != -1) {
      heapify(myRightChildIndex);
      swapIfNecessary(myIndex, myRightChildIndex);
    }
  }

  private void swapIfNecessary(int rootIndex, int childIndex){
    T myValue = base.get(rootIndex);
    if(childIndex != -1){
      T myLeftChildValue = base.get(childIndex);
      if(shouldBeSwaped(myLeftChildValue, myValue)){
        base.set(childIndex, myValue);
        base.set(rootIndex, myLeftChildValue);
      }
    }
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

  private boolean shouldBeSwaped(T t1, T t2){
    if(type == Type.MINHEAP){
      return t1.compareTo(t2) < 0;
    } else {
      return t1.compareTo(t2) > 0;
    }
  }


}
