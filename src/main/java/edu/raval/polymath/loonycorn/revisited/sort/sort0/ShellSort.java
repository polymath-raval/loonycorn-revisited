package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import java.util.Arrays;

public class ShellSort implements ISort {

  public static void main(String[] args) {
    int increment = 3;
    for (int start = 0; start < increment; start++) {
      new ShellSort().sort(new int[10]);
    }
  }

  @Override
  public int[] sort(int[] input) {
    for (int increment = input.length / 2; increment >= 1; increment = increment / 2) {
      for (int start = 0; start < increment; start++) {
        sort(input, start, increment);
      }
    }
    return input;
  }

  private void sort(int[] input, int start, int increment) {
    for (int i = start; i + increment < input.length; i = i + increment) {
      for (int j = i + increment; j > start; j = j - increment) {
        if (input[j] < input[j - increment]) {
          int temp = input[j];
          input[j] = input[j - increment];
          input[j - increment] = temp;
        } else {
          break;
        }
      }
    }
  }

}
