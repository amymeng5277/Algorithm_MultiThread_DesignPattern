package test;

/**
 * Created by mengdongqi on 17-09-05.
 */
public class LongestPalindromic {

  public String Longest_Palindromic(String s) {
    char[] sChar = s.toCharArray();
    int len = sChar.length;
    while (len >= 0) {
      for (int i = 0; i + len - 1 < sChar.length; i++) {
        int left = i;
        int right = i+len - 1;
        boolean resCheck = true;
        while(left<right){
          if(sChar[left] !=sChar[right]){
            resCheck = false;
            break;
          }
          left++;
          right --;
        }
        if(resCheck)
          return s.substring(i,i+len);
      }
      len--;
    }
    return "";
  }

  public static void main(String args[]){
    String s = "ababad";
    LongestPalindromic lp = new LongestPalindromic();
    System.out.println(lp.Longest_Palindromic(s));
  }
}
