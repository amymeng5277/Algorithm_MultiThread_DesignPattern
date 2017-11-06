package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengdongqi on 17-09-06.
 */

class Process {
  int arrTime;
  int exeTime;

  Process(int arr, int exe) {
    arrTime = arr;
    exeTime = exe;
  }
}
public class RoundRobin {
  public float Solution(int[] Atime, int[] Etime, int q) {
    if(Atime==null || Etime == null || Atime.length!=Etime.length)
      return 0;
    Queue<Process> robin = new LinkedList<>();
    int index = 0,waitTime = 0, currTime = 0;
    while(index<Atime.length || !robin.isEmpty()){
      if(robin.isEmpty()){
        robin.offer(new Process(Atime[index],Etime[index]));
        currTime = Atime[index++];
      }else{
        Process p = robin.poll();
        waitTime +=currTime-p.arrTime;
        currTime +=Math.min(q,p.exeTime);
        for(;index<Atime.length && Atime[index]<currTime;index++){
          robin.offer(new Process(Atime[index],Etime[index]));
        }
        if(p.exeTime>q){
          robin.offer(new Process(currTime,p.exeTime-q));
        }
      }
    }
    return (float)waitTime/Atime.length;
  }
  public static void main(String args[]){
    int[] Atime = {0,1,4};
    int[] Etime = {5,2,3};
    RoundRobin rb = new RoundRobin();
    System.out.println(rb.Solution(Atime, Etime, 3));
  }
}
