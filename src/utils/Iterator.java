package utils;

public class Iterator<T> {
    T data;
    Iterator<T> next;

    public Iterator(T data) {
        this.data = data;
        this.next = null;
    }

    public boolean hasNext(){
        return !(next == null);
    }
}
