package test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class SortJobFirst {
  public float Solution(int[] req, int[] dur) {
    if (req.length == 0 || dur.length == 0 || req.length != dur.length)
      return 0;
    int len = req.length;
    PriorityQueue<Process> cpu = new PriorityQueue<>(new Comparator<Process>() {
      public int compare(Process p1, Process p2) {
        if (p1.exeTime != p2.exeTime)
          return p1.exeTime - p2.exeTime;
        return p1.arrTime - p2.arrTime;
      }
    });
    int index = 0;
    int currTime = 0, waitTime = 0;
    while (!cpu.isEmpty() || index < len) {
      if (cpu.isEmpty()) {
        cpu.offer(new Process(req[index], dur[index]));
        currTime = req[index++];
      } else {
        Process p = cpu.poll();
        waitTime += currTime - p.arrTime;
        currTime += p.exeTime;
        while (index < len && req[index] < currTime) {
          cpu.add(new Process(req[index], dur[index]));
          index++;
        }
      }
    }
    return (float) waitTime / len;
  }

  public static void main(String args[]) {
    SortJobFirst sf = new SortJobFirst();
    int[] req = {1, 2, 4, 6, 7, 12, 15};
    int[] dur = {3, 3, 3, 5, 8, 10, 10};
    System.out.println(sf.Solution(req, dur));
  }
}
