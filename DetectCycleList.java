package test;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class DetectCycleList {
  public boolean hasCycle(ListNode head) {
    if(head==null){
      return false;
    }
    ListNode fast =head;
    ListNode slow =head;
    while(fast.next.next!=null && fast.next!=null){
      fast = fast.next.next;
      slow = slow.next;
      if(fast==slow)
        return true;
    }
    return false;
  }
  public ListNode detectCycle(ListNode head) {
    if(head==null){
      return null;
    }
    ListNode fast =head;
    ListNode slow =head;
    ListNode entry = head;
    while(fast.next.next!=null && fast.next!=null){
      fast = fast.next.next;
      slow = slow.next;
      if(fast==slow){
        while(entry!=slow){
          entry = entry.next;
          slow = slow.next;
        }
        return entry;
      }

    }
    return null;
  }
}
