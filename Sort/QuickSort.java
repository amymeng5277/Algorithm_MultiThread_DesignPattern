package test.Sort;

/**
 * Created by mengdongqi on 17-09-30.
 */
public class QuickSort {
  public void swap(int[]array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  public int partition(int[]array,int left,int right){
    int privlot = array[right];
    int storeIndex = left;
    while(left<right){
      if(array[left]<=privlot){
        swap(array,storeIndex,left);
        storeIndex++;
      }
      left++;
    }
    swap(array,storeIndex,right);
    return storeIndex;
  }
  public void sort(int[]array,int left,int right){
    if(left>right)
      return;
    int storeIndex = partition(array,left,right);
    sort(array,left,storeIndex-1);
    sort(array,storeIndex+1,right);
  }
  public static void main(String args[]){
    int array[] = {3,3,7,1,0,-1,8,9,11,10,6,2,3};
    QuickSort qs = new QuickSort();
    qs.sort(array,0,array.length-1);
    for(int elem: array)
      System.out.print(elem+", ");
  }
}
