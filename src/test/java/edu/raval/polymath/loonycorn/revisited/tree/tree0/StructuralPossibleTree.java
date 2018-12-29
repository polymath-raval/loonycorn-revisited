package edu.raval.polymath.loonycorn.revisited.tree.tree0;

public class StructuralPossibleTree {

  public int compute(int numberOfVertex) {
    if (numberOfVertex < 2) {
      return 1;
    } else {
      int[] lookup = new int[numberOfVertex + 1];
      lookup[0] = 1;
      lookup[1] = 1;
      for (int i = 2; i <= numberOfVertex; i++) {
        for (int j = 0; j < i; j++) {
          lookup[i] = lookup[i] + (lookup[j] * lookup[i - 1 - j]);
        }
      }
      return lookup[numberOfVertex];
    }
  }

}
