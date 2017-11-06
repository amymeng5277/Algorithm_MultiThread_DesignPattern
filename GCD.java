package test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class GCD {
  public int Solution(int[] array) {
    if (array == null || array.length == 1) return 0;
    int gcd = array[0];
    for (int i = 1; i < array.length; i++) {
      gcd = gcd(gcd, array[i]);
    }
    return gcd;
  }
  private int gcd(int num1, int num2) {
    if (num1 == 0 || num2 == 0) return 0;
    while(num1!=0 && num2!=0){
    if(num1<num2){
       num2 = num2 % num1;
    }else{
      num1 = num1 % num2;
    }
    }

    return num1 + num2;
  }
  public static void main(String args[]){
    int [] array = {2};
    GCD gd  = new GCD();
    System.out.println(gd.Solution(array));
    PriorityQueue queue =new PriorityQueue();
    Map<Integer,Integer> map = new HashMap<>();
  }
}
