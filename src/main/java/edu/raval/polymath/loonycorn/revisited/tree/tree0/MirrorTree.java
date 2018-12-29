package edu.raval.polymath.loonycorn.revisited.tree.tree0;

public class MirrorTree<T extends Comparable<T>> {

  public BinarySearchTree<T> mirror(BinarySearchTree<T> orgTree){
    if(orgTree.getRoot() == null)
      return null;
    BinarySearchTree<T> mirrored = new BinarySearchTree<>();
    mirrored.add(orgTree.getRoot().getValue());
    mirror(orgTree.getRoot(), mirrored.getRoot());
    return mirrored;
  }
  private void mirror(Node<T> org, Node<T> mirror){
    mirror.setValue(org.getValue());
    if(org.getRight() != null){
      mirror.setLeft(new Node<>(null));
      mirror(org.getRight(), mirror.getLeft());
    }
    if(org.getLeft() != null){
      mirror.setRight(new Node<>(null));
      mirror(org.getLeft(), mirror.getRight());
    }
  }
}
