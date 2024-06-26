public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int start;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
        start = 0;
    }

    private void resize(int capacity) {
        if (capacity > size) {
            T[] a = (T[]) new Object[capacity];
            int head = nextFirst + 1;
            int tail = nextLast - 1;
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (head < size) {
                    a[i] = items[head];
                    head += 1;
                } else {
                    a[i] = items[j];
                    j += 1;
                }
            }
            nextLast = size;
            nextFirst = capacity - 1;
            items = a;
        }
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == 0) {
            items[0] = item;
            size += 1;
            nextLast += 1;
        } else if (size == items.length) {
            resize(size * 2);
            items[nextFirst] = item;
            nextFirst -= 1;
        } else {
            nextFirst = items.length - 1;
            while (items[nextFirst] != null) {
                nextFirst -= 1;
            }
            items[nextFirst] = item;
            size += 1;
            nextFirst -= 1;
        }
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
            items[size] = item;
            size += 1;
            nextLast += 1;
        } else {
            items[nextLast] = item;
            size += 1;
            nextLast += 1;
        }
    }

    /* Returns true if deque is empty, false otherwise. */
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

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        if (size == 0) {
            System.out.print("null");
        } else {
            int head = nextFirst + 1;
            int tail = nextLast - 1;
            while (head < items.length) {
                System.out.print(items[head] + " ");
                head += 1;
            }
            for (int j = 0; j <= tail; j++) {
                System.out.print(items[j] + " ");
            }
        }
    }

    /*
     * Removes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int head = nextFirst + 1;
        if (head < items.length) {
            nextFirst += 1;
            T ele = items[head];
            items[head] = null;
            size -= 1;
            return ele;
        } else if (head == items.length) {
            head = start;
            size -= 1;
            T ele = items[head];
            items[head] = null;
            nextFirst = start;
            return ele;
        }
        return null;
    }

    /*
     * Removes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int tail = nextLast - 1;
        if (tail >= 0) {
            T ele = items[tail];
            items[tail] = null;
            nextLast -= 1;
            size -= 1;
            return ele;
        } else if (tail == -1) {
            tail = items.length - 1;
            size -= 1;
            T ele = items[tail];
            items[tail] = null;
            nextLast = items.length - 1;
            return ele;
        }
        return null;
    }

    /*
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque
     */
    public T get(int index) {
        if (size == 0) {
            return null;
        } else {
            return items[index];
        }
    }
}

// public static void main(String[] args) {
// ArrayDeque<String> L = new ArrayDeque<>();
// L.addFirst("1");
// L.addLast("2");
// L.addFirst("3");
// L.addFirst("4");
// L.addLast("5");
// L.addFirst("6");
// L.removeFirst();
// L.removeFirst();
// L.removeFirst();
// L.removeFirst();
// L.removeFirst();
// L.removeFirst();
// L.removeFirst();
// L.removeFirst();
// }
