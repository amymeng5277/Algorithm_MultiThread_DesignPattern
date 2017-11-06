package test.Sort;

/**
 * Created by mengdongqi on 17-09-30.
 */
public class BubbleSort {
  public void bubbleSort(int []array){
    for(int i=0;i<array.length;i++){
      for(int j=1;j<array.length-i;j++){
        if(array[j]<array[j-1]){
          int temp = array[j-1];
          array[j-1] = array[j];
          array[j] = temp;
        }
      }
    }
  }
  public static void main(String args[]){
    int array[] = {3,3,7,1,0,-1,8,9,11,10,6,3};
    BubbleSort bs = new BubbleSort();
    bs.bubbleSort(array);
    for(int elem: array)
      System.out.print(elem+", ");
  }
}
