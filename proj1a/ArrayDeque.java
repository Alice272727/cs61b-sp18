public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity) {
        if (capacity > size) {
            T[] a = (T[]) new Object[capacity];
            int head = nextFirst + 1;
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
        } else {
            T[] a = (T[]) new Object[capacity];
            int head = nextFirst + 1;
            int j = 0;
            for (int i = 0; i < capacity; i++) {
                if (head < items.length) {
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
            items[nextFirst] = item;
            nextFirst = nextFirst - 1;
            if (nextFirst < 0) {
                nextFirst = items.length - 1;
            }
            size += 1;
        } else if (size == items.length) {
            resize(size * 2);
            items[nextFirst] = item;
            nextFirst -= 1;
            size += 1;
        } else {
            items[nextFirst] = item;
            size += 1;
            nextFirst -= 1;
            if (nextFirst < 0) {
                nextFirst = items.length - 1;
            }
        }
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == 0) {
            items[nextLast] = item;
            nextLast += 1;
            size += 1;
        } else if (size == items.length) {
            resize(size * 2);
            items[nextLast] = item;
            nextLast += 1;
            size += 1;
        } else {
            items[nextLast] = item;
            nextLast += 1;
            if (nextLast >= items.length) {
                nextLast = nextLast % items.length;
            }
            size += 1;
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
        if (size <= (items.length * 0.5) && items.length > 8) {
            resize(items.length / 2);
        }
        int head = nextFirst + 1;
        if (head < items.length) {
            T ele = items[head];
            items[head] = null;
            nextFirst += 1;
            if (nextFirst == items.length) {
                nextFirst = -1;
            }
            size -= 1;
            return ele;
        } else {
            head = head % items.length;
            T ele = items[head];
            items[head] = null;
            nextFirst += 1;
            // nextFirst = nextFirst % items.length;
            return ele;
        }
    }

    /*
     * Removes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size <= (items.length * 0.5) && items.length > 8) {
            resize(items.length / 2);
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
            T ele = items[tail];
            items[tail] = null;
            nextLast = items.length - 1;
            size -= 1;
            return ele;
        }
        return null;
    }

    /*
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque
     */
    public T get(int index) {
        if (nextFirst > items.length) {
            nextFirst = nextFirst % items.length;
        }
        int head = nextFirst + 1;
        if (head >= items.length) {
            head = head % items.length;
        }
        int count = 0;
        if (index < size) {
            for (int i = 0; i < items.length; i++) {
                if (count == index) {
                    return items[head];
                } else {
                    count += 1;
                    head += 1;
                    if (head >= items.length) {
                        head = head % items.length;
                    }
                }
            }
        }
        return null;
    }

    // public static void main(String[] args) {
    // ArrayDeque<Integer> A = new ArrayDeque<>();
    // A.addFirst(0);
    // A.removeLast();
    // A.addFirst(2);
    // A.addLast(3);
    // A.addLast(4);
    // A.size();
    // A.removeLast();
    // A.removeFirst();
    // }
    // for (int i = 0; i < 16; i++) {
    // A.addLast(i);
    // }
    // int b = A.get(0);
    // int c = A.get(15);
    // int d = A.get(16);
    // }

}
