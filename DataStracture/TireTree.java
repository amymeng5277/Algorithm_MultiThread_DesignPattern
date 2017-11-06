package test.DataStracture;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengdongqi on 17-10-01.
 */
class TireNode {
  private TireNode[] childern;
  private int numberOfWord;
  private boolean isWord;

  TireNode() {
    childern = new TireNode[26];
  }

  public TireNode[] getChildren() {
    return childern;
  }

  public TireNode getChild(char c) {
    return childern[c - 'a'];
  }

  public void setChild(char c) {
    childern[c - 'a'] = new TireNode();
    numberOfWord++;
  }

  public int getNumberOfWord() {
    return numberOfWord;
  }

  public void setNumberOfWord(int numberOfWord) {
    this.numberOfWord = numberOfWord;
  }

  public boolean isWord() {
    return isWord;
  }

  public void setIsWord(boolean isWord) {
    this.isWord = isWord;
  }

}

public class TireTree {
  TireNode root;

  TireTree() {
    root = new TireNode();
  }

  public void insert(String s, TireNode root) {
    TireNode child = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      TireNode[]childeren = child.getChildren();
      if(childeren[c-'a']==null){
        childeren[c-'a']=new TireNode();
      }
      child = childeren[c-'a'];
    }
    child.setIsWord(true);
  }

  public void print() {
    Queue<TireNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TireNode[] children = queue.poll().getChildren();
        for (char i = 'a'; i <= 'z'; i++) {
          if (children[i - 'a'] != null) {
            queue.add(children[i - 'a']);
            System.out.print(i + "");
          } else {
            System.out.print("*");
          }
        }
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    TireTree root = new TireTree();
    root.insert("meng", root.root);
    root.insert("mexg", root.root);
    root.print();
  }
}
