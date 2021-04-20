public class LinkedListDeque<T> implements Deque<T>{
    private  int size;
    private class LinkedNode {
        private T item;
        private LinkedNode next;
        private LinkedNode prev;
        public LinkedNode (T i , LinkedNode n , LinkedNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private LinkedNode sentinel;

    public LinkedListDeque() {
        sentinel = new LinkedNode(null , new LinkedNode(null , null , null) , new LinkedNode(null , null , null));
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (isEmpty()) {
            LinkedNode p = new LinkedNode(item , null , null);
            p.next = p;
            p.prev = p;
            sentinel.next = p;
        } else {
            LinkedNode p = new LinkedNode(item , sentinel.next , sentinel.next.prev);
            sentinel.next.prev = p;
            sentinel.prev.next = p;
            sentinel.next = p;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (isEmpty()) {
            LinkedNode p = new LinkedNode(item , null , null);
            p.next = p;
            p.prev = p;
            sentinel.next = p;
        } else {
            LinkedNode p = new LinkedNode(item , sentinel.next , sentinel.next.prev);
            sentinel.next.prev.next = p;
            sentinel.next.prev = p;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        if (size==0)  { return true; }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) System.out.println("null");
        int count = 0;
        LinkedNode p = sentinel;
        while (count < size) {
            System.out.print(p.next.item + " ");
            count += 1;
            p = p.next;
        }

    }

    @Override
    public T removeFirst() {
        if (isEmpty())  { return null; }
        T value = sentinel.next.item;
        sentinel.next.next.prev = sentinel.next.prev;
        sentinel.next.prev.next = sentinel.next.next;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return  value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) { return null; }
        T value = sentinel.next.prev.item;
        sentinel.next.prev.prev.next = sentinel.next;
        sentinel.next.prev = sentinel.next.prev.prev;
        size -= 1;
        return value;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index > size - 1) { return null; }
        int count = 0;
        LinkedNode p = sentinel.next;
        while (count != index) {
            p = p.next;
            count += 1;
        }
        return p.item;
    }

    private T getRecursive(int index,LinkedNode p) {
        if (index == 0 ) { return p.item; }
        else return getRecursive(index - 1 , p.next);
    }
    public T getRecursive(int index) {
        if (isEmpty() || index > size - 1) { return null;}
        LinkedNode p = sentinel.next;
        return  getRecursive(index , p);
    }
}

