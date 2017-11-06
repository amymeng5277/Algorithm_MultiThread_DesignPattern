package test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mengdongqi on 17-09-06.
 */

class Point{
    int x;
    int y;
  Point(int x,int y){
    this.x = x;
    this.y = y;
  }
    }
public class KNearestP {
  public Point[] Solution(Point[] array, Point origin, int k){
    Point[] res = new Point[k];
    PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        return (int)(getDistance(o2,origin)-getDistance(o1,origin));
      }
    });
    for(int i=0;i<array.length;i++){
      pq.offer(array[i]);
      if(pq.size()>k){
        pq.poll();
      }
    }
    int index = 0;
    while(!pq.isEmpty()){
        res[index++] = pq.poll();
    }
    return res;
  }
  public double getDistance(Point o1, Point o2){
    return Math.sqrt((o1.x-o2.x)*(o1.x-o2.x)+(o1.y-o2.y)*(o1.y-o2.y));
  }
  public static void main(String args[]){
    Point [] array = new Point[10];
    for(int i=0;i<10;i++){
      array[i] = new Point(i,i);
    }
    KNearestP kp = new KNearestP();
    Point []res = kp.Solution(array,new Point(0,0),5);
    for(Point elem: res){
      System.out.println("("+elem.x +" ," + elem.y +")");
    }
  }
}
