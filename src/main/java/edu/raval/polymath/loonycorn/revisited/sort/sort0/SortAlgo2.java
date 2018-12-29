package edu.raval.polymath.loonycorn.revisited.sort.sort0;

public class SortAlgo2 implements ISort {


  public void sort(int[] input) {
    int count = 0;
    for (int i = 0; i < input.length; i++) {
      boolean wasSwapped = false;
      for (int j = 0; j < input.length - 1; j++) {
        count++;
        if (isSwapRequired(input, j, j + 1)) {
          swap(input, j, j + 1);
          wasSwapped = true;
        }
      }
      if(!wasSwapped){
        break;
      }
    }
    System.out.println("Count " + count);
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
