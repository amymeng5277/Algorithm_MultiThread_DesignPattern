package test;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class InsertCycleList {
  public ListNode Solution(ListNode head, int val) {
    if(head ==null){
      ListNode newnode = new ListNode(val);
      newnode.next = newnode;
      return newnode;
    }
    ListNode curr = head;
    do{
      if(val>=curr.val && val<=curr.next.val) break;
      if(curr.val>curr.next.val && (val<curr.next.val || val>curr.val)) break;
      curr = curr.next;
    }while(curr!=head);
    ListNode newNode = new ListNode(val);
    newNode.next = curr.next;
    curr.next = newNode;
    return newNode;
  }
}
