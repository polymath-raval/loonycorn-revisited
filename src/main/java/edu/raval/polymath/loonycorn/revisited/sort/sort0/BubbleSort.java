package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import java.util.Arrays;

public class BubbleSort implements ISort {


  public int[] sort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      boolean wasSwapped = false;
      for (int j = input.length-1; j > i; j--) {
        if (isSwapRequired(input, j - 1,j)) {
          swap(input, j - 1, j);
          wasSwapped = true;
        }
      }
      //System.out.println(i + " *** " + Arrays.toString(input));
      if(!wasSwapped){
        break;
      }
    }
    return input;
  }

  private boolean isSwapRequired(int[] input, int i, int j) {
    return input[i] > input[j];
  }

  private void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }

}
