package edu.raval.polymath.loonycorn.revisited.tree.tree0;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal<T extends Comparable<T>> {
  private final BinarySearchTree<T> tree;
  private final List<T> result = new ArrayList<>();

  private InOrderTraversal(BinarySearchTree<T> tree) {
    this.tree = tree;
  }

  public static <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree){
    InOrderTraversal<T> traversal = new InOrderTraversal<>(tree);
    traversal.traverse(tree.getRoot());
    return traversal.result;
  }

  private void traverse(Node<T> node){
    if(node == null)
      return;

    traverse(node.getLeft());
    result.add(node.getValue());
    traverse(node.getRight());
  }
}
