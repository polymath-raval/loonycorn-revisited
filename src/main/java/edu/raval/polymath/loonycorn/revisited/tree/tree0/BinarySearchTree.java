package edu.raval.polymath.loonycorn.revisited.tree.tree0;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

  Node<T> root;

  public void add(T value) {
    if (root == null) {
      root = createNode(value);
    } else {
      add(root, value);
    }
  }

  public T search(T value) {
    if (root == null) {
      return null;
    } else {
      return search(root, value);
    }
  }

  public int height() {
    return height(root);
  }

  public T minimum() {
    return minimum(root);
  }

  public T maximum() {
    return maximum(root);
  }

  public boolean isBST() {
    return isBST(root);
  }

  Node<T> getRoot(){
    return this.root;
  }


  private boolean isBST(Node<T> node) {
    return node == null ? true :
        (isBST(node.getLeft())
            && isBST(node.getRight())
            && (node.getLeft() == null || node.getValue().compareTo(node.getLeft().getValue()) > 0)
            && (node.getRight() == null
            || node.getValue().compareTo(node.getRight().getValue()) < 0));
  }

  private T minimum(Node<T> node) {
    return node == null ? null :
        (node.getLeft() != null ? minimum(node.getLeft()) : node.getValue());
  }

  private T maximum(Node<T> node) {
    return node == null ? null :
        (node.getRight() != null ? maximum(node.getRight()) : node.getValue());
  }

  private int height(Node<T> node) {
    return node == null ? 0 :
        1 + Integer.max(height(node.getLeft()), height(node.getRight()));
  }

  private T search(Node<T> node, T value) {
    if (node == null) {
      return null;
    } else if (node.getValue().compareTo(value) == 0) {
      return node.getValue();
    } else if (node.getValue().compareTo(value) > 0) {
      return search(node.getLeft(), value);
    } else {
      return search(node.getRight(), value);
    }
  }

  private void add(Node<T> node, T value) {
    if (node.getValue().compareTo(value) == 0) {
      return;
    } else if (node.getValue().compareTo(value) > 0) {
      if (node.getLeft() == null) {
        node.setLeft(createNode(value));
      } else {
        add(node.getLeft(), value);
      }
    } else {
      if (node.getRight() == null) {
        node.setRight(createNode(value));
      } else {
        add(node.getRight(), value);
      }
    }

    node.setHeight(inferHeight(node));
    node.setBalanceFactor(inferBalanceFactor(node));

    llRotation(node);
    lrRotation(node);
    rlRotation(node);
    rrRotation(node);
  }

  private void llRotation(Node<T> node) {
    if (node.getBalanceFactor() < -1 && node.getLeft().getBalanceFactor() < 0) {
      Node<T> newRight = createNode(node.getValue(), node.getLeft().getRight(), node.getRight());

      node.setValue(node.getLeft().getValue());
      node.setRight(newRight);
      node.setLeft(node.getLeft().getLeft());
      node.setBalanceFactor(inferBalanceFactor(node));
      node.setHeight(inferHeight(node));
    }
  }

  private void lrRotation(Node<T> node) {
    if (node.getBalanceFactor() < -1 && node.getLeft().getBalanceFactor() > 0) {
      Node<T> newLeft =
          createNode(node.getLeft().getValue(), node.getLeft().getLeft(),
              node.getLeft().getRight().getLeft());
      Node<T> newRight =
          createNode(node.getValue(), node.getLeft().getRight().getRight(), node.getRight());

      node.setValue(node.getLeft().getRight().getValue());
      node.setLeft(newLeft);
      node.setRight(newRight);
      node.setHeight(inferHeight(node));
      node.setBalanceFactor(inferBalanceFactor(node));
    }
  }

  private void rlRotation(Node<T> node) {
    if (node.getBalanceFactor() > 1 && node.getRight().getBalanceFactor() < 0) {
      Node<T> newLeft =
          createNode(node.getValue(), node.getLeft(), node.getRight().getLeft().getLeft());
      Node<T> newRight =
          createNode(node.getRight().getValue(), node.getRight().getLeft().getRight(),
              node.getRight().getRight());

      node.setValue(node.getRight().getLeft().getValue());
      node.setLeft(newLeft);
      node.setRight(newRight);
      node.setHeight(inferHeight(node));
      node.setBalanceFactor(inferBalanceFactor(node));
    }
  }

  private void rrRotation(Node<T> node) {
    if (node.getBalanceFactor() > 1 && node.getRight().getBalanceFactor() > 0) {
      Node<T> newLeft = createNode(node.getValue(), node.getLeft(), node.getRight().getLeft());
      node.setValue(node.getRight().getValue());
      node.setLeft(newLeft);
      node.setRight(node.getRight().getRight());
      node.setBalanceFactor(inferBalanceFactor(node));
      node.setHeight(inferHeight(node));
    }
  }

  private Node<T> createNode(T value, Node<T> left, Node<T> right) {
    Node<T> newNode = new Node<>(value, left, right);
    newNode.setHeight(inferHeight(newNode));
    newNode.setBalanceFactor(inferBalanceFactor(newNode));
    return newNode;
  }

  private Node<T> createNode(T value) {
    return new Node<>(value, null, null);
  }

  private int inferHeight(Node<T> node) {
    int leftHeight = node.getLeft() == null ? 0 : node.getLeft().getHeight();
    int rightHeight = node.getRight() == null ? 0 : node.getRight().getHeight();
    return 1 + Integer.max(leftHeight, rightHeight);
  }

  private int inferBalanceFactor(Node<T> node) {
    int leftHeight = node.getLeft() == null ? 0 : node.getLeft().getHeight();
    int rightHeight = node.getRight() == null ? 0 : node.getRight().getHeight();
    return (rightHeight - leftHeight);
  }
}
