package test;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class RectangleOverlap {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int innerL = Math.max(A,E);
    int innerR = Math.max(innerL,Math.min(C,G));
    int innerT = Math.max(B,F);
    int innerB = Math.max(innerT,Math.min(D,H));
    return (C-A)*(D-B) - (innerR-innerL)*(innerB-innerT) + (G-E)*(H-F);

  }

  boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
  {
    // If one rectangle is on left side of other
    if (l1.x > r2.x || l2.x > r1.x)
      return false;

    // If one rectangle is above other
    if (l1.y < r2.y || l2.y < r1.y)
      return false;

    return true;
  }
  public static void main(String args[]){
    RectangleOverlap ro = new RectangleOverlap();
    System.out.println(ro.computeArea(-2,-2,2,2,-2,-2,2,2));
  }
}
