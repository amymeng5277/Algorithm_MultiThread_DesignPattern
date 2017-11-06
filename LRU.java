package test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class LRU {

  public int Solution(int[] array, int size) {
    List<Integer> cache = new LinkedList<>();
    int count = 0;
    for(int i=0;i<array.length;i++){
      if(cache.contains(array[i])){
        cache.remove(new Integer(array[i]));
      }else{
        count++;
        if(cache.size()==size)
          cache.remove(0);
      }
      cache.add(array[i]);
    }
    return count;
  }
  public static void main(String args[]){
    int []array = {1,2,3,4,5,1,3,4,7};
    LRU lr = new LRU();
    System.out.println(lr.Solution(array,4));
  }
}
