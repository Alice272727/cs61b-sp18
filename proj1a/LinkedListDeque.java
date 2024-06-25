public class LinkedListDeque<T> {
  private TNode sentinel;
  private int size;

  private class TNode {
    public TNode prev;
    public T item;
    public TNode next;

    public TNode(TNode prev0, T item0, TNode next0) {
      prev = prev0;
      item = item0;
      next = next0;
    }
  }

  public LinkedListDeque() {
    sentinel = new TNode(null, null, null);
    size = 0;
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
  }

  /* Adds an item pf type T to the front of the deque */
  public void addFirst(T item) {
    if (size == 0) {
      sentinel.next = new TNode(sentinel, item, sentinel);
      sentinel.prev = sentinel.next;
      size += 1;
    } else {
      TNode PNext = sentinel.next;
      sentinel.next = new TNode(sentinel, item, PNext);
      PNext.prev = sentinel.next;
      size += 1;
    }
  }

  // public static void main(String[] args) {
  // LinkedListDeque<String> L = new LinkedListDeque<>();
  // L.addFirst("1");
  // L.addFirst("2");
  // L.addFirst("3");
  // }

  /* Adds an item of type T to the back of the deque */
  public void addLast(T item) {
    if (size == 0) {
      sentinel.next = new TNode(sentinel, item, sentinel);
      sentinel.prev = sentinel.next;
      size += 1;
    } else {
      TNode SLast = sentinel.prev;
      SLast.next = new TNode(SLast, item, sentinel);
      sentinel.prev = SLast.next;
      size += 1;
    }
  }

  /* returns true if deque is empty,false otherwise */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /* returns the number of items in the deque */
  public int size() {
    return size;
  }

  /* prints the items in the deque from first to last, separated by a space */
  public void printDeque() {
    if (size == 0) {
      System.out.print("null");
    } else {
      for (int i = 0; i < size; i++) {
        System.out.print(sentinel.next.item + " ");
        sentinel = sentinel.next;
      }
    }
  }

  /* removes and returns the item at the front of the deque */
  public T removeFirst() {
    if (size == 0) {
      return null;
    } else if (size == 1) {
      TNode first_item = sentinel.next;
      sentinel.next = sentinel;
      sentinel.prev = sentinel;
      size -= 1;
      return first_item.item;
    } else {
      TNode first_item = sentinel.next;
      sentinel.next = first_item.next;
      first_item.next.prev = sentinel;
      size -= 1;
      return first_item.item;
    }
  }

  /* removes and returns the item at the back of the deque */
  public T removeLast() {
    if (size == 0) {
      return null;
    } else if (size == 1) {
      TNode last_item = sentinel.next;
      sentinel.next = sentinel;
      sentinel.prev = sentinel;
      size -= 1;
      return last_item.item;

    } else {
      TNode last_item = sentinel.prev;
      last_item.prev.next = sentinel;
      sentinel.prev = last_item.prev;
      size -= 1;
      return last_item.item;
    }
  }

  /*
   * gets the item at the given index, where 0 is the front, 1 is the next item,
   * and so forth. If no such item exists, returns null
   */
  public T get(int index) {
    TNode find_ele = null;
    if (size == 0) {
      return null;
    } else {
      for (int i = 0; i < size; i++) {
        if (i == index) {
          find_ele = sentinel.next;
          break;
        } else {
          sentinel = sentinel.next;
          continue;
        }
      }
      return find_ele.item;
    }
  }

  /* same as get, but uses recursion */
  public T getRecursive(int index) {
    if (size == 0) {
      return null;
    } else if (index == 1) {
      sentinel = sentinel.next.next;
      return sentinel.item;
    } else if (index == 0) {
      return sentinel.next.item;
    } else {
      sentinel = sentinel.next;
      return getRecursive(index - 1);
    }
  }

}
