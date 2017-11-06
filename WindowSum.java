package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class WindowSum {
  public List<Integer> GetSum(List<Integer> A, int k) {
    List<Integer> res = new ArrayList<>();
    int currentSum = 0;
    for(int i=0;i<A.size();i++){
      if(i<k)
        currentSum+=A.get(i);
      else{
        res.add(currentSum);
        currentSum-=A.get(i-k);
        currentSum+=A.get(i);
      }
    }
    res.add(currentSum);
    return res;
  }
  public static void main(String args[]){
    WindowSum ws = new WindowSum();
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<10;i++){
      list.add(i);
    }
    List <Integer>res = ws.GetSum(list,3);
    for(Integer elem : res){
      System.out.println(elem);
    }
  }
}
