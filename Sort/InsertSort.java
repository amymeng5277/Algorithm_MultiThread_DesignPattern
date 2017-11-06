package test.Sort;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengdongqi on 17-09-30.
 */
public class InsertSort {
  public void insertSort(int array[]){
    for(int i=1;i<array.length;i++){
      int curr = array[i];
      int j=i-1;
      while(j>=0 && array[j]>curr){
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = curr;
    }
  }
  public static void main(String []args){
    int array[] =  {3,3,7,1,0,-1,8,9,11,10,6,3};
    InsertSort is = new InsertSort();
    is.insertSort(array);
    for(int elem:array)
      System.out.print(elem+", ");

  }
}
