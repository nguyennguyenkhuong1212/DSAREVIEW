package utils;

public class Stack<T> {

    private int size;
    private Iterator<T> top;

    public Stack() {
        size = 0;
        top = null;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T element){
        if (empty()){
            top = new Iterator<T>(element);
            size++;
            return;
        }
        Iterator<T> temp = new Iterator<T>(element);
        temp.next = top;
        top = temp;
        size++;
    }

    public T peek() {
        if (empty()) return null;
        return top.data;
    }

    public T pop(){
        if (empty()) return null;
        T temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    public void clear(){
        size = 0;
        top = null;
    }

    @Override
    public String toString(){
        if (empty()) return "[]";
        Iterator<T> cur = top;
        StringBuilder res = new StringBuilder("]");
        while (cur.hasNext()){
            res.append(cur.data.toString()).append(" ,");
            cur = cur.next;
        }
        res.append(cur.data).append("[");
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
