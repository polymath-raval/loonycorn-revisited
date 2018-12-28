package edu.raval.polymath.loonycorn.revisited.tree.tree0;

public class Node<T extends Comparable<T>> {
  private T node;
  private Node<T> right;
  private Node<T> left;

  public Node(T node) {
    this.node = node;
  }

  public Node(T node, Node<T> right, Node<T> left) {
    this.node = node;
    this.right = right;
    this.left = left;
  }

  public T getNode() {
    return node;
  }

  public void setNode(T node) {
    this.node = node;
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
}
