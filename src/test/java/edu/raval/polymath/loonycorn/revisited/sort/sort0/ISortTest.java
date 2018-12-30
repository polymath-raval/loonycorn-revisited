package edu.raval.polymath.loonycorn.revisited.sort.sort0;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ISortTest {
  /*private static int range = 100_000_000;
  private static int size = 100_000_000;
  */
  private static int range = 100_000;
  private static int size = 100_000;

  private static int[] input;

  @Test
  public void MergeSort(){
    outOfPlaceSort(new MergeSort());
  }

  @Test
  public void QuickSort(){
    inplaceSort(new QuickSort());
  }

  @Test
  public void SelectionSort(){
    inplaceSort(new SelectionSort());
  }

  @Test
  public void BubbleSort(){
    inplaceSort(new BubbleSort());
  }

  @Test
  public void InsertionSort(){
    inplaceSort(new InsertionSort());
  }

  @Test
  public void ShellSort(){
    inplaceSort(new ShellSort());
  }

  private void outOfPlaceSort(ISort sort){
    int[] input = initArray(size);
    //System.out.println(Arrays.toString(input));
    int[] output = sort.sort(input);
    //System.out.println(Arrays.toString(output));
    int last = Integer.MIN_VALUE;
    for(int i:output){
      Assert.assertTrue(last <= i);
      last = i;
    }
  }

  private void inplaceSort(ISort sort) {
    int[] input = initArray(size);
    //System.out.println(Arrays.toString(input));
    sort.sort(input);
    //System.out.println(Arrays.toString(input));
    int last = Integer.MIN_VALUE;
    for(int i:input){
      Assert.assertTrue(last <= i);
      last = i;
    }
  }

  private int[] initArray(int size){
    if(input == null){
      System.out.println("Initialize Array");
      input = new int[size];
      for (int i = 0; i < input.length; i++) {
        input[i] = (int) (Math.random() * range);
      }
    }
    return Arrays.copyOf(input, input.length);
  }
}