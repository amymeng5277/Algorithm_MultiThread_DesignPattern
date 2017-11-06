package test.DataStracture;

/**
 * Created by mengdongqi on 17-10-01.
 */
class Node {
  String key;
  String value;
  int hash;
  Node next = null;

  Node(String key, String value) {
    this.key = key;
    this.value = value;
    this.hash = Math.abs(key.hashCode());
  }
}

public class HashMap {
  private final static int CAPACITY = 2;
  private Node[] array;
  private int currentSize;
  private int capacity;

  public HashMap() {
    array = new Node[CAPACITY];
    currentSize = 0;
    capacity = CAPACITY;
  }

  public HashMap(int capacity) {
    this.capacity = capacity;
    currentSize = 0;
    array = new Node[capacity];
  }

  public int getSize() {
    return currentSize;
  }

  public String getValue(String key) {
    int currtHash = Math.abs(key.hashCode());
    int index = currtHash % capacity;
    Node curr = array[index];
    while (curr != null) {
      if (curr.hash == currtHash)
        return curr.value;
      curr = curr.next;
    }
    return null;
  }

  public boolean ifContainsKey(String key) {
    int currtHash = Math.abs(key.hashCode());
    int index = currtHash % capacity;
    Node curr = array[index];
    while (curr != null) {
      if (curr.hash == currtHash)
        return true;
      curr = curr.next;
    }
    return false;
  }

  public void add(String key, String value) {
    Node addNode = new Node(key, value);
    int index = addNode.hash % capacity;
    Node curr = array[index];
    while (curr != null && curr.next != null) {
      if (curr.hash == addNode.hash) {
        curr.value = value;
        return;
      }
      curr = curr.next;
    }
    if (curr != null) {
      if (curr.hash == addNode.hash) {
        curr.value = value;
        return;
      } else
        curr.next = addNode;
    } else
      array[index] = addNode;
    currentSize++;
  }

  public static void main(String args[]) {
    HashMap hm = new HashMap(2);
    hm.add("Amy", "meng");
    hm.add("Morgan", "Wu");
    hm.add("Amy", "Wang");
    hm.add("zahh", "sjdhkj");
    System.out.println(hm.getValue("Amy"));
    System.out.println(hm.getValue("Morgan"));
    System.out.println(hm.getValue("zahh"));
    System.out.println(hm.getSize());
  }
}
