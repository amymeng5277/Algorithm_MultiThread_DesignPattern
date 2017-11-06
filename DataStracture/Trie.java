package test.DataStracture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengdongqi on 17-10-26.
 */
public class Trie {
  class TrieNode {
    TrieNode[] childs = new TrieNode[26];
    boolean isWord = false;
    char val;

    TrieNode() {
    }


  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
    root.val = ' ';
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode start = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (start.childs[c - 'A'] == null) {
        start.childs[c - 'A'] = new TrieNode();
        start.childs[c - 'A'].val = c;
      }
      start = start.childs[c - 'A'];
    }
    start.isWord = true;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieNode start = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (start.childs[c - 'A'] == null) {
        return false;
      }
      start = start.childs[c - 'A'];
    }
    return start.isWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode start = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (start.childs[c - 'A'] == null) {
        return false;
      }
      start = start.childs[c - 'A'];
    }
    return true;
  }
  public List<String>searchWordByPrefix(String prefix){
    List<String>res = new ArrayList<>();
    TrieNode start = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (start.childs[c - 'A'] == null) {
        return res;
      }
      start = start.childs[c - 'A'];
    }
    StringBuilder sb = new StringBuilder();
    sb.append(prefix);
    TrieNode node = start;
    helper(res,sb,node);
    return res;
  }
  public void helper(List<String> res,StringBuilder sb, TrieNode node){
     if(node.isWord){
      res.add(sb.toString());
    }
    for(int i=0;i<26;i++){
      if(node.childs[i]!=null){
        helper(res, new StringBuilder(sb).append(node.childs[i].val), node.childs[i]);
      }
    }
  }
  public static int binarySearch(String[]words,String prefix){
    int left = 0;
    int right = words.length;
    int currentIndex = 0;
    int startIndex = 0;
    while(left<right && currentIndex<prefix.length()){
      int middle = (left+right)/2;
      char middleChar = words[middle].charAt(currentIndex);
      char c = prefix.charAt(currentIndex);
      if(middleChar<c){
        left = middle;
        continue;
      }else if(middleChar>c){
        right = middle;
        continue;
      }else{
        int findIndex = middle;
        while(findIndex>=startIndex && words[findIndex].charAt(currentIndex)==c){
          findIndex--;
        }
        startIndex = findIndex+1;
        left = startIndex;
        right  = words.length;
        currentIndex++;
        if(currentIndex==prefix.length()){
          return startIndex;
        }
        continue;
      }
    }
    return -1;
  }
  public static int getIndex(String[] words, String prefix){
    int left = 0;
    int right = words.length-1;

    while(left<=right){
      int middle = (left+right)/2;
      String currentWord = words[middle];
      if(currentWord.length()<prefix.length()){
        left = middle+1;
      }else{
        String substring = currentWord.substring(0,prefix.length());
        if(substring.compareTo(prefix)>0){
          right = middle-1;
        }else if(substring.compareTo(prefix)<0){
          left = middle+1;
        }else{
          if(middle>0){
            if(words[middle-1].substring(0,prefix.length()).equals(prefix)){
              left = 0;
              right = middle-1;
            }else{
              return middle;
            }
          }else{
            return middle;
          }
        }
      }
    }
    return -1;
  }
  public static List<String>getWords(String[] words, String prefix){
    int index = getIndex(words,prefix);
    List<String> res = new ArrayList<>();
    if(index==-1){
      res.add("<NONE>");
      return res;
    }
    while(index<words.length){
      if(words[index].substring(0,prefix.length()).equals(prefix)){
        res.add(words[index]);
        index++;
      }
      else
        break;
    }
    return res;
  }
  public static void main(String args[]){
    Trie tree = new Trie();
    String[] words = {"ACETAMINOPHEN","ASPERGEL","ASPRIN","ASPERTAME","ATAVAN","BUPROPION"};
//    for(int i=0;i<words.length;i++){
//      tree.insert(words[i]);
//    }
    List<String>res=getWords(words, "AC");
    //List<String>res =tree.searchWordByPrefix("AV");
    for(String elem:res){
      System.out.print(elem+"," );
    }

  }
}
