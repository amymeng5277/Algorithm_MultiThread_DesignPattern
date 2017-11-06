package test.Sort;

/**
 * Created by mengdongqi on 17-09-30.
 */
public class MergeSort {
  public void mergeSort(int[] array, int left, int right) {
    int mid = (left + right)/2;
    if(left<right){
      mergeSort(array,left,mid);
      mergeSort(array,mid+1,right);
      merge(array,left,right,mid);
    }
  }

  public void merge(int []array, int left, int right, int middle) {
    int [] temp = new int[right-left+1];
    int index1 = left;
    int index2 = middle+1;
    int count = 0;
    while(index1<=middle && index2<=right){
      if(array[index1]<array[index2]){
        temp[count++]=array[index1];
        index1++;
      }else{
        temp[count++]=array[index2];
        index2++;
      }
    }
    while(index1<=middle)
      temp[count++] = array[index1++];
    while(index2<=right)
      temp[count++] = array[index2++];
    for(int i = 0;i<temp.length;i++){
      array[left+i] = temp[i];
    }
  }
  public static void main(String []args){
    int array[] =  {3,3,7,1,0,-1,8,9,11,10,6,3,2};
    MergeSort ms = new MergeSort();
    ms.mergeSort(array,0,array.length-1);
    for(int elem:array)
      System.out.print(elem+", ");
  }

}
