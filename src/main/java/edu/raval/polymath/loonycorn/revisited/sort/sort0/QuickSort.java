package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import java.util.Arrays;

public class QuickSort implements ISort {

  @Override
  public int[] sort(int[] input) {
    quickSort(input, 0, input.length-1);
    return input;
  }

  private void quickSort(int[] input, int start, int end){
    if(end > start){
      int pivotIndex = partition(input, start, end);
      quickSort(input, start, pivotIndex-1);
      quickSort(input, pivotIndex+1, end);
    }
  }

  private int partition(int[] input, int start, int end){
    int pivotValue = input[end];
    int pivotIndex = start;
    for(int i = start; i < end;i++ ){
      if(input[i] < pivotValue){
        swap(input, i, pivotIndex);
        pivotIndex++;
      }
    }
    swap(input, pivotIndex, end);
    return pivotIndex;
  }

  private void swap(int[] input, int i, int j){
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
