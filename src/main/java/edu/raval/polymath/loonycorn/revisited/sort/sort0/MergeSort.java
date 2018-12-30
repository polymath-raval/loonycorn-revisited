package edu.raval.polymath.loonycorn.revisited.sort.sort0;

public class MergeSort implements ISort {

  @Override
  public int[] sort(int[] input) {
    return mergeSort(input);
  }

  private int[] mergeSort(int[] input) {
    if (input.length == 1) {
      return input;
    }
    int[] firstHalf = new int[input.length / 2];
    int[] secondHalf = new int[input.length - (input.length / 2)];
    split(input, firstHalf, secondHalf);

    int[] output = new int[input.length];
    merge(output, mergeSort(firstHalf), mergeSort(secondHalf));
    return output;
  }

  private void merge(int[] output, int[] firstHalf, int[] secondHalf) {
    int outputIndex = 0;
    int firstHalfIndex = 0;
    int secondHalfIndex = 0;

    while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
      if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
        output[outputIndex++] = firstHalf[firstHalfIndex++];
      } else {
        output[outputIndex++] = secondHalf[secondHalfIndex++];
      }
    }
    while (firstHalfIndex < firstHalf.length) {
      output[outputIndex++] = firstHalf[firstHalfIndex++];
    }
    while (secondHalfIndex < secondHalf.length) {
      output[outputIndex++] = secondHalf[secondHalfIndex++];
    }
  }

  private void split(int[] input, int[] firstHalf, int[] secondHalf) {
    for (int i = 0; i < input.length; i++) {
      if (i < firstHalf.length) {
        firstHalf[i] = input[i];
      } else {
        secondHalf[i - firstHalf.length] = input[i];
      }
    }
  }
}
