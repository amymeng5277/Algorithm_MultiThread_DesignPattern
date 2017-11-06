package test.Sort;

/**
 * Created by mengdongqi on 17-09-30.
 */
public class HeapSort {
  public int[] array;
  private int capacity;
  private int currentSize;

  HeapSort() {
    array = new int[16];
    capacity = 16;
    currentSize = 0;
  }

  HeapSort(int capacity) {
    array = new int[capacity];
    this.capacity = capacity;
    this.currentSize = 0;
  }

  public void add(int elem) {
    int index = getSize();
    array[index] = elem;
    currentSize++;
    heapifyUp(index);
  }

  public int popMin() {
    int min = array[0];
    int lastElem = array[getSize() - 1];
    array[getSize() - 1] = 0;
    currentSize--;
    array[0] = lastElem;
    heapifyDown(0);
    return min;
  }

  public int getSize() {
    return currentSize;
  }

  public int leftIndex(int index) {
    return (index + 1) * 2 - 1;
  }

  public int rightIndex(int index) {
    return (index + 1) * 2;
  }

  public int parentIndex(int index) {
    return (int) Math.floor((index + 1) / 2) - 1;
  }

  public void heapifyDown(int i) throws ArrayIndexOutOfBoundsException {
    int l = leftIndex(i);
    int r = rightIndex(i);
    int min;

    //find index of smallest key in the children
    if (l < getSize() && array[l] < array[i])
      min = l;
    else
      min = i;
    if (r < getSize() && array[r] < array[min])
      min = r;
    //swap with child with smallest key if found
    if (min != i) {
      int temp = array[i];
      array[i] = array[min];
      array[min] = temp;
      heapifyDown(min);
    }

  }

  public void heapifyUp(int i) throws ArrayIndexOutOfBoundsException {
    int parent = parentIndex(i);
    if (parent >= 0) {
      if (array[i] < array[parent]) {
        int temp = array[i];
        array[i] = array[parent];
        array[parent] = temp;
        heapifyUp(parent);
      }
    }
  }

  public static void main(String args[]) {
    int array[] = {3, 3, 7, 1, 0, -1, 8, 9, 11, 10, 6, 3,2,100};
    HeapSort hs = new HeapSort();
    for (int i = 0; i < array.length; i++) {
      hs.add(array[i]);
    }
    while (hs.getSize() != 0) {
      System.out.print(hs.popMin() + ", ");
    }
//    for(int elem:hs.array){
//      System.out.print(elem + ", ");
//    }
  }
}
