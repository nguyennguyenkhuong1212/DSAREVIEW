package utils;

public class Queue<T> {

    private int size;
    private Iterator<T> head;

    public Queue() {
        size = 0;
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T element){
        if (empty()){
            head = new Iterator<>(element);
            size++;
            return;
        }
        Iterator<T> cur = head;
        while (cur.hasNext()) cur = cur.next;
        cur.next = new Iterator<>(element);
        size++;
    }

    public T peek() {
        if (empty()) return null;
        return head.data;
    }

    public T pop(){
        if (empty()){
            return null;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public void clear(){
        size = 0;
        head = null;
    }

    @Override
    public String toString(){
        if (empty()) return "[]";
        Iterator<T> cur = head;
        StringBuilder res = new StringBuilder("[");
        while (cur.hasNext()){
            res.append(cur.data.toString()).append(", ");
            cur = cur.next;
        }
        res.append(cur.data).append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue <Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(4);
        queue.push(9);
        queue.push(7);
        queue.push(5);
    }
}
