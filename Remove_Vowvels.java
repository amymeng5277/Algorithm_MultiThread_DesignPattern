package test;

/**
 * Created by mengdongqi on 17-09-05.
 */
public class Remove_Vowvels {
  String vowvel = "aeiouAEIOU";
  public String removal(String orgin){
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(i<orgin.length()){
      if(vowvel.indexOf(orgin.charAt(i)+"")!=-1){
        i++;
        continue;
      }

      sb.append(orgin.charAt(i));
      i++;
    }
    return sb.toString();
  }
  public static void main(String args[]){
    String a = "Dongqi Eeng";
    Remove_Vowvels rv = new Remove_Vowvels();
    System.out.println(rv.removal(a));
  }
}
