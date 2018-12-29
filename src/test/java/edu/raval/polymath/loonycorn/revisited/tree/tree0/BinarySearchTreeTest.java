package edu.raval.polymath.loonycorn.revisited.tree.tree0;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.SetUtils;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void IsBST() {
    for (int i = 1; i < 1000; i++) {
      Assert.assertTrue(bst(i).isBST());
    }
  }

  @Test
  public void Height() {
    for (int i = 1; i < 1000; i++) {
      int idealH = (int) Math.ceil(Math.log(i) / Math.log(2));
      int idealH1 = 1 + (int) Math.ceil(Math.log(i) / Math.log(2));
      Assert.assertTrue(bst(i).height() == idealH || bst(i).height() == idealH1);
    }
  }

  @Test
  public void Maximum() {
    for (int i = 2; i < 1000; i++) {
      Assert.assertTrue(i - 1 == bst(i).maximum());
    }
  }

  @Test
  public void Minimum() {
    for (int i = 2; i < 1000; i++) {
      Assert.assertTrue(1 == bst(i).minimum());
    }

  }

  @Test
  public void Search() {
    BinarySearchTree<Integer> bst = bst(1000);
    for (int i = 1; i < 1000; i++) {
      Assert.assertTrue(bst.search(i) == i);
    }
    for (int i = 1001; i < 1100; i++) {
      Assert.assertNull(bst.search(i));
    }

  }

  @Test
  public void InOrderTraversal() {
    List<Integer> inOrderTraversal = InOrderTraversal.traverse(bst(1000));
    for (int i = 1; i <= inOrderTraversal.size(); i++) {
      Assert.assertTrue(i == inOrderTraversal.get(i - 1));
    }
  }


  @Test
  public void PreOrderTraversal() {
    List<Integer> expected = Arrays.asList(4, 2, 1, 3, 6, 5, 8, 7, 9);
    Assert.assertTrue(
        ListUtils.isEqualList(expected, PreOrderTraversal.traverse(bst(10))));

  }

  @Test
  public void PostOrderTraversal() {
    List<Integer> expected = Arrays.asList(1, 3, 2, 5, 7, 9, 8, 6, 4);
    Assert.assertTrue(
        ListUtils.isEqualList(expected, PostOrderTraversal.traverse(bst(10))));

  }

  @Test
  public void BreadthFirstTraversal() {
    List<Integer> expected = Arrays.asList(4, 2, 6, 1, 3, 5, 8, 7, 9);
    Assert.assertTrue(
        ListUtils.isEqualList(expected, BreadthFirstTraversal.traverse(bst(10))));

  }

  @Test
  public void mirrorTree() {
    List<Integer> expected = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1);
    List<Integer> actual =
        InOrderTraversal.traverse(new MirrorTree<Integer>().mirror(bst(10)));
    Assert.assertTrue(ListUtils.isEqualList(expected, actual));
  }

  @Test
  public void searchTree() {
    int size = 500_000;
    BigDecimal minimum = new BigDecimal(10_000);
    BigDecimal maximum = new BigDecimal(20_000);
    Set<BigDecimal> expected = new HashSet<>();

    BinarySearchTree<BigDecimal> bst = new BinarySearchTree<>();
    for (int i = 1; i < size; i++) {
      BigDecimal value = new BigDecimal(Math.random() * 100_000);
      if (value.compareTo(minimum) >= 0 && value.compareTo(maximum) <= 0) {
        expected.add(value);
      }
      bst.add(value);
    }

    Set<BigDecimal> actual = new HashSet<>(bst.search(minimum, maximum));
    Assert.assertTrue(SetUtils.isEqualSet(expected, actual));
  }


  private BinarySearchTree<Integer> bst(int size) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    for (int i = 1; i < size; i++) {
      bst.add(i);
    }
    return bst;
  }


}