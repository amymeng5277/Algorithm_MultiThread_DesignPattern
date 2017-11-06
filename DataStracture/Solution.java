package test.DataStracture;

import java.util.*;

/**
 * Created by mengdongqi on 17-10-02.
 */
class Solution {
  Map<String,Set<String>> path = new java.util.HashMap<>();
  List<List<String>> listPath = new ArrayList<>();
  List<List<String>> res = new ArrayList<>();
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>();
    for(String word:wordList){
      wordSet.add(word);
    }
    if(!wordSet.contains(endWord)){
      return res;
    }
    Set<String> inQueue = new HashSet<>();
    Set<String> visit = new HashSet();
    Queue<String>queue = new LinkedList<>();
    queue.offer(beginWord);
    inQueue.add(beginWord);
    while(!queue.isEmpty()){
      int size = queue.size();
      while(size>0){
        String curr = queue.poll();
        visit.add(curr);
        char []wordChar = curr.toCharArray();
        for(int i=0;i<wordChar.length;i++){
          char oldChar = wordChar[i];
          for(char c='a';c<='z';c++ ){
            if(c==oldChar)
              continue;
            wordChar[i]=c;
            String newWord = String.valueOf(wordChar);
            if(wordSet.contains(newWord)){
              if(!inQueue.contains(newWord)){
                queue.offer(newWord);
                inQueue.add(newWord);
              }
              if(!visit.contains(newWord) && visit.contains(curr)){
                if(!path.containsKey(newWord))
                  path.put(newWord,new HashSet<>());
                path.get(newWord).add(curr);
              }
            }
            wordChar[i] = oldChar;
          }
        }
        size--;
      }
    }
    getPath(beginWord,endWord,new Stack<>());
    reversePath();
    return res;

  }
  public void getPath(String beginWord,String endWord,List<String> list){
    if(!path.containsKey(endWord)){
      if(endWord.equals(beginWord)){
        list.add(endWord);
          listPath.add(list);
      }
      return;
    }
    list.add(endWord);
    Set<String> preWords = path.get(endWord);
    for(String preWord:preWords){
      getPath(beginWord,preWord,new ArrayList<String>(list));
    }
  }
  public void reversePath(){
    for(List<String> path:listPath){
      List<String> list = new ArrayList<>();
      for(int i=path.size()-1;i>=0;i--)
        list.add(path.get(i));
      res.add(list);
    }
  }
  public static void main(String args[]){
    Solution s = new Solution();
    String beginWord = "hit";
    String endWord = "cog";
    String[] words= {"hot","dot","dog","lot","log","cog"};
    List<String> wordList = Arrays.asList(words);
    List<List<String>> listPath=s.findLadders(beginWord, endWord, wordList);
    for(List<String> list:listPath){
      for(String word:list)
        System.out.print(word + ", ");
      System.out.println();
    }
  }
}
