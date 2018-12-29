package edu.raval.polymath.loonycorn.revisited.tree.tree0;

public class Node<T extends Comparable<T>> {
  private T value;
  private Node<T> left;
  private Node<T> right;
  private int height = 1;
  private int balanceFactor = 0;

  public Node(T value) {
    this.value = value;
  }

  public Node(T value, Node<T> left, Node<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getBalanceFactor() {
    return balanceFactor;
  }

  public void setBalanceFactor(int balanceFactor) {
    this.balanceFactor = balanceFactor;
  }

  //@Override
  /*public String toString() {
    return "Node{" +
        "value=" + value +
        ", height=" + height +
        ", balanceFactor=" + balanceFactor +
        ", left=" + left +
        ", right=" + right +
        '}';
  }*/

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
