package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengdongqi on 17-10-26.
 */
public class OUTTHINK {
  List<String> number(int n,int p,int q){
    List<String> res = new ArrayList<>();
    for(int i=1;i<=n;i++){
      String c = i+"";
      String sub = q+"";
      if(i%p==0 && !c.contains(sub)){
        res.add("OUT");
      }else if(i%p!=0 && c.contains(sub)){
        res.add("THINK");
      }else if(i%p==0 && c.contains(sub)){
        res.add("OUTTHINK");
      }else {
        res.add(i + "");
      }
    }
    return res;
  }
  public static void main(String args[]){
    List<String>res = new ArrayList<>();
    OUTTHINK ot = new OUTTHINK();
    res = ot.number(100,7,3);
    String s = "dsad";
    s.compareTo("13234");
    for(String elem:res){
      System.out.print(elem+", ");
    }
  }
}
