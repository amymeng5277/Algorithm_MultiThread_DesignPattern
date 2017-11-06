package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target){
    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
      if(map.containsKey(target - nums[i]))
        return new int[]{map.get(target - nums[i]),i};
      map.put(nums[i],i);
    }
    return new int[]{0,0};
  }

  public static void main(String args[]){
    int []a = {1,2,3,4,5};
    int taget = 3;
    TwoSum ts = new TwoSum();
    int [] res = ts.twoSum(a,taget);
    for(int elem : res)
      System.out.println(elem);
  }
}
