package test.DataStracture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mengdongqi on 17-10-01.
 */
class TreeNode {
  private TreeNode left;
  private TreeNode right;
  private int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  TreeNode(int value) {
    this.value = value;
  }
}

public class BalanceSearchTree {
  TreeNode root;
  int treeSize;

  BalanceSearchTree(int value) {
    root = new TreeNode(value);
    treeSize = 1;
  }

  public void insert(TreeNode root, int value) {
    TreeNode curr = new TreeNode(value);
    if (value < root.getValue()) {
      if (root.getLeft() == null){
        root.setLeft(curr);
        treeSize++;
        return;
      }
      else
        insert(root.getLeft(), value);
    } else {
      if (root.getRight() == null) {
        root.setRight(curr);
        treeSize++;
        return;
      } else {
        insert(root.getRight(), value);
      }
    }
  }

  public void inOrder(TreeNode root, List<TreeNode> list) {
    if (root == null)
      return;
    inOrder(root.getLeft(), list);
    list.add(root);
    inOrder(root.getRight(), list);
  }

  public void remove(BalanceSearchTree root,int value){
    if(root==null)
      return;
    TreeNode[]temp = search(root.root,value,null);
    if(temp==null)
      return;
    List<TreeNode> order = new ArrayList<>();
    inOrder(root.root,order);
    boolean hasParent = true;
    boolean isLeft = true;
    TreeNode parent = temp[0];
    TreeNode curr = temp[1];
    if(parent == null)
      hasParent = false;
    else {
      if(parent.getRight().getValue()==curr.getValue())
        isLeft = false;
    }
    if(curr.getLeft()==null&&curr.getRight()==null){
        if(!hasParent){
          root.root = null;
          return;
        }
        else{
          if(isLeft){
            parent.setLeft(null);
            return;
          }
          else{
            parent.setRight(null);
            return;
          }
        }
    }else{
      if(curr.getLeft()!=null && curr.getRight()==null){
        if(!hasParent)
          root.root = curr.getLeft();
        else {
          if(isLeft){
            parent.setLeft(curr.getLeft());
            return;
          }else{
            parent.setRight(curr.getLeft());
            return;
          }
        }

      }else if(curr.getLeft()==null && curr.getRight()!=null){
        if(!hasParent)
          root.root = curr.getRight();
        else {
          if(isLeft){
            parent.setLeft(curr.getRight());
            return;
          }else{
            parent.setRight(curr.getRight());
            return;
          }
        }
      }else{
        TreeNode succesor = null;
        for(int i=0;i<order.size();i++){
          if (curr.getValue()==order.get(i).getValue()){
            if(i==0)
              succesor = order.get(i+1);
            else
              succesor = order.get(i-1);
          }
        }

          if(!hasParent)
            root.root = succesor;
          else{
            if(isLeft)
              parent.setLeft(succesor);
            else
              parent.setRight(succesor);
          }
        remove(root,succesor.getValue());
      }
    }

  }

  public TreeNode[] search( TreeNode root,int value,TreeNode parent) {
    if (root == null)
      return null;
    if (value == root.getValue())
      return new TreeNode[]{parent,root};
    else if (value < root.getValue()) {
      return search(root.getLeft(),value,root);
    }
    return search(root.getRight(),value,root);
  }

  public static void main(String args[]) {
    BalanceSearchTree bst = new BalanceSearchTree(5);
    bst.insert(bst.root, 10);
    bst.insert(bst.root, 7);
    bst.insert(bst.root, 11);
    bst.insert(bst.root, 1);
    bst.insert(bst.root, 6);
    bst.insert(bst.root, 12);
    List<TreeNode> array = new ArrayList<>();
    bst.inOrder(bst.root, array);
    for (TreeNode elem : array)
      System.out.print(elem.getValue() + ", ");
    TreeNode[]temp = bst.search(bst.root,10,null);
    System.out.println();
    System.out.println("Parent: "+temp[0].getValue());
    System.out.println("current: "+temp[1].getValue());
    bst.remove(bst, 10);
    array.clear();
    bst.inOrder(bst.root, array);
    System.out.println();
    for (TreeNode elem : array)
      System.out.print(elem.getValue() + ", ");
    System.out.println();


  }
}
