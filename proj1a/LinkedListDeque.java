public class LinkedListDeque<T> {
  private TNode sentinel;
  private int size;

  public class TNode {
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

  public static void main(String[] args) {
    LinkedListDeque<String> L = new LinkedListDeque<>();
    L.addFirst("1");
    L.addFirst("2");
    L.addFirst("3");
  }
  // public void addLast(T item) {

  // }

  // public boolean isEmpty() {

  // }

  // public int size() {

  // }

  // public void printDeque() {

  // }

  // public T removeFirst() {

  // }

  // public T removeLast() {

  // }

  // public T get(int index) {

  // }
}
