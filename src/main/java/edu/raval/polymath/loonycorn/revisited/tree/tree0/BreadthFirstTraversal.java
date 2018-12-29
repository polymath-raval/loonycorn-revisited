package edu.raval.polymath.loonycorn.revisited.tree.tree0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal {

  public static <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
    Queue<Node<T>> traversalQueue = new LinkedList<>();
    traversalQueue.offer(tree.root);
    List<T> result = new ArrayList<>();
    while (!traversalQueue.isEmpty()) {
      Node<T> node = traversalQueue.poll();
      result.add(node.getValue());
      if (node.getLeft() != null)
        traversalQueue.offer(node.getLeft());
      if (node.getRight() != null)
        traversalQueue.offer(node.getRight());
    }
    return result;
  }


}