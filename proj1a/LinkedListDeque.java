public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    private class TNode {
        private TNode prev;
        private T item;
        private TNode next;

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
            TNode pNext = sentinel.next;
            sentinel.next = new TNode(sentinel, item, pNext);
            pNext.prev = sentinel.next;
            size += 1;
        }
    }

    // public static void main(String[] args) {

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if (size == 0) {
            sentinel.next = new TNode(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        } else {
            TNode sLast = sentinel.prev;
            sLast.next = new TNode(sLast, item, sentinel);
            sentinel.prev = sLast.next;
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
            TNode firstItem = sentinel.next;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size -= 1;
            return firstItem.item;
        } else {
            TNode firstItem = sentinel.next;
            sentinel.next = firstItem.next;
            firstItem.next.prev = sentinel;
            size -= 1;
            return firstItem.item;
        }
    }

    /* removes and returns the item at the back of the deque */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            TNode lastItem = sentinel.next;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size -= 1;
            return lastItem.item;

        } else {
            TNode lastItem = sentinel.prev;
            lastItem.prev.next = sentinel;
            sentinel.prev = lastItem.prev;
            size -= 1;
            return lastItem.item;
        }
    }

    /*
     * gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null
     */
    public T get(int index) {
        TNode findEle = null;
        TNode sentinelA = sentinel;
        if (size == 0) {
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    findEle = sentinelA.next;
                    break;
                } else {
                    sentinelA = sentinelA.next;
                    continue;
                }
            }
            return findEle.item;
        }
    }

    /* same as get, but uses recursion */
    public T getRecursive(int index) {
        return nextNode(sentinel.next, index);
    }

    private T nextNode(TNode N, int i) {
        if (i == 0) {
            return N.item;
        } else {
            return nextNode(N.next, i - 1);
        }
    }

    // public static void main(String[] args) {
    // LinkedListDeque<Integer> L = new LinkedListDeque<>();
    // L.addFirst(1);
    // L.addLast(2);
    // L.get(0);
    // L.get(1);
    // L.addLast(5);
    // L.addLast(6);
    // L.get(3);
    // L.addLast(8);
    // L.get(2);
    // }

}
