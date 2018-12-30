package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import java.util.Arrays;

public class InsertionSort implements ISort {

  @Override
  public int[] sort(int[] input) {
    for (int i = 0; i < input.length - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (input[j] < input[j - 1]) {
          int temp = input[j];
          input[j] = input[j - 1];
          input[j - 1] = temp;
        } else {
          //System.out.println(i + " *** done early" );
          break;
        }
      }
      //System.out.println(i + " *** " + Arrays.toString(input));
    }
    return input;
  }
}
