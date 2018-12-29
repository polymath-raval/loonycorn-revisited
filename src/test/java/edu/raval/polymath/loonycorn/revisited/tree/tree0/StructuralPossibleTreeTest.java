package edu.raval.polymath.loonycorn.revisited.tree.tree0;

import static org.junit.Assert.*;

import org.junit.Test;

public class StructuralPossibleTreeTest {

  @Test
  public void compute() {
    for (int i = 0; i < 10; i++) {
      System.out.println(i + " --> " + new StructuralPossibleTree().compute(i));
    }
  }
}