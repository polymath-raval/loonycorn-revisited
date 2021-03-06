package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import java.util.Arrays;

public class SelectionSort implements ISort{


  public int[] sort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = i; j < input.length; j++) {
        if (isSwapRequired(input, i, j)) {
          swap(input, i, j);
        }
      }
    }
    return input;
  }

  private boolean isSwapRequired(int[] input, int i, int j){
    return input[i] > input[j];
  }

  private void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }

}
