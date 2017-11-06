package test;

import java.util.Stack;

/**
 * Created by mengdongqi on 17-09-05.
 */
public class Vaild_Paird {
  public boolean checkVaild (String pattern){
    if(pattern == null || pattern.length()==0)
      return false;
    Stack<Character> statck = new Stack<>();
    for(int i=0;i<pattern.length();i++){
      if(statck.isEmpty())
        statck.push(pattern.charAt(i));
      else if(pattern.charAt(i)-statck.peek() ==1 || pattern.charAt(i)-statck.peek() ==2)
        statck.pop();
      else
        statck.push(pattern.charAt(i));
    }
    return statck.empty();
  }
  public static void main(String args[]){
    String a = "(())";
    Vaild_Paird vp = new Vaild_Paird();
    if(vp.checkVaild(a))
      System.out.println("True");
    else{
      System.out.println("False");
    }
  }
}
