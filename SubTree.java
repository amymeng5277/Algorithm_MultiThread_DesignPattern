package test;

/**
 * Created by mengdongqi on 17-09-06.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
public class SubTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if(t == null)
      return true;
    if(s == null)
      return false;
    return (isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right, t));
  }
  public boolean isSameTree(TreeNode s, TreeNode t){
    if(s == null && t== null)
      return true;
    if(s == null || t==null)
      return false;
    if(s.val != t.val)
      return false;
    return(isSameTree(s.left, t.left) && isSameTree(s.right, t.right));
  }
}
