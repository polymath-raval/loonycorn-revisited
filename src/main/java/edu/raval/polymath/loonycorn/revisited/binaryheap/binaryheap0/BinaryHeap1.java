package edu.raval.polymath.loonycorn.revisited.binaryheap.binaryheap0;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap1<T extends Comparable<T>> implements IBinaryHeap<T> {

  public enum Type{
    MINHEAP, MAXHEAP;
  }

  private final Type type;
  private List<T> base;


  public BinaryHeap1(Type t){
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
    bottomsUpHeapify(getParentIndex(base.size()-1));
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
      topsDownHeapify(0);
    } else {
      base.clear();
    }
    //System.out.println(base);
    return first;
  }

  private void bottomsUpHeapify(int myIndex) {
    if(myIndex == -1){
      return;
    }
    int myLeftChildIndex = getLeftChildIndex(myIndex);
    int myRightChildIndex = getRightChildIndex(myIndex);
    boolean changeOccured = false;
    if (myLeftChildIndex != -1) {
      changeOccured = changeOccured | swapIfNecessary(myIndex, myLeftChildIndex);
    }
    if (myRightChildIndex != -1) {
      changeOccured = changeOccured | swapIfNecessary(myIndex, myRightChildIndex);
    }
    if(changeOccured){
      bottomsUpHeapify(getParentIndex(myIndex));
    }
  }

  private void topsDownHeapify(int myIndex) {
    int myLeftChildIndex = getLeftChildIndex(myIndex);
    int myRightChildIndex = getRightChildIndex(myIndex);
    if (myLeftChildIndex != -1 && swapIfNecessary(myIndex, myLeftChildIndex))  {
      topsDownHeapify(myLeftChildIndex);
    }
    if (myRightChildIndex != -1 && swapIfNecessary(myIndex, myRightChildIndex)) {
      topsDownHeapify(myRightChildIndex);
    }
  }

  private boolean swapIfNecessary(int rootIndex, int childIndex){
    T myValue = base.get(rootIndex);
    if(childIndex != -1){
      T myLeftChildValue = base.get(childIndex);
      if(shouldBeSwaped(myLeftChildValue, myValue)){
        base.set(childIndex, myValue);
        base.set(rootIndex, myLeftChildValue);
        return true;
      }
    }
    return false;
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
