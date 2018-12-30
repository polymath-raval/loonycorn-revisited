package edu.raval.polymath.loonycorn.revisited.sort.sort0;

public interface ISort {

  static int search(int searchParam, int[] sortedArr, int startIndex, int endIndex) {
    if(startIndex >  endIndex){
      return -1;
    }
    int midIndex = (startIndex + endIndex) / 2;
    int midValue = sortedArr[midIndex];
    if (searchParam == midValue) {
      return midIndex;
    } else if (searchParam < midValue) {
      return search(searchParam, sortedArr, startIndex, midIndex-1);
    } else {
      return search(searchParam, sortedArr, midIndex + 1, endIndex);
    }
  }

  int[] sort(int[] input);
}
