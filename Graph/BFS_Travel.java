package test.Graph;

import java.util.*;

/**
 * Created by mengdongqi on 17-10-02.
 */
public class BFS_Travel {
  Map<Integer, Set<Integer>> edgeMap = new HashMap<>();

  void getEdgeMap(List<int[]> edge) {
    for (int i = 0; i < edge.size(); i++) {
      int start = edge.get(i)[0];
      int end = edge.get(i)[1];
      if (!edgeMap.containsKey(start))
        edgeMap.put(start, new HashSet<>());
      if (!edgeMap.containsKey(end))
        edgeMap.put(end, new HashSet<>());
      edgeMap.get(start).add(end);
      edgeMap.get(end).add(start);
    }
  }

  List<List<Integer>> bfaTravle(int startPoit, int endPoint) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(startPoit);
    Map<Integer, Set<Integer>> path = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        int curr = queue.poll();
        visit.add(curr);
        Set<Integer> edge = edgeMap.get(curr);
        if (edge == null)
          break;
       Iterator<Integer> integerIterator= edge.iterator();
        while(integerIterator.hasNext()) {
          int next = integerIterator.next();
          if (!visit.contains(next)) {
            queue.offer(next);
            if (!path.containsKey(next)) {
              path.put(next, new HashSet<>());
            }
            path.get(next).add(curr);
          }
        }
        size--;
      }
    }
    getPath(path, startPoit,endPoint, new ArrayList<>(), res);
    return res;
  }

  void getPath(Map<Integer, Set<Integer>> path, int start,int end, List<Integer> temp, List<List<Integer>> res) {
    if (!path.containsKey(end)) {
      if(end==start){
        temp.add(end);
        res.add(temp);
        return;
      }
      return;
    }
    temp.add(end);
    Set<Integer> parents = path.get(end);
    for (Integer parent : parents) {
      //temp.add(parent);
      getPath(path, start,parent, new ArrayList<>(temp), res);
    }
  }

  public static void main(String args[]) {
    int[] edge1 = {0,2};
    int[] edge2 = {2,1};
    int[] edge3 = {2,3};
    int[] edge4 = {3,4};
    int[] edge5 = {4,1};
//    int[] edge6 = {6, 10};
//    int[] edge7 = {10, 8};
    List<int[]> edges = new ArrayList<>();
    edges.add(edge1);
    edges.add(edge2);
    edges.add(edge3);
    edges.add(edge4);
    edges.add(edge5);
//    edges.add(edge6);
//    edges.add(edge7);
    BFS_Travel bt = new BFS_Travel();
    bt.getEdgeMap(edges);
    List<List<Integer>> path = bt.bfaTravle(4,0);
    for (List<Integer> list : path) {
      for (Integer elem : list)
        System.out.print(elem + ", ");
      System.out.println();
    }
  }
}
