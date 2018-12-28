package edu.raval.polymath.loonycorn.revisited.tree.tree0;

public class BinarySearchTree<T extends Comparable<T>> {

  Node<T> root;

  public void add(T value) {
    if(root == null){
      root = new Node<>(value);
    } else {
      add(root, value);
    }
  }

  private void add(Node<T> parent, T value) {
    if (parent.getNode().compareTo(value) == 0) {
      return;
    } else if (parent.getNode().compareTo(value) < 0) {
      if (parent.getLeft() == null) {
        parent.setLeft(new Node<>(value));
      } else {
        add(parent.getLeft(), value);
      }
    } else {
      if(parent.getRight() == null) {
        parent.setRight(new Node<>(value));
      } else {
        add(parent.getRight(), value);
      }
    }
  }
}
