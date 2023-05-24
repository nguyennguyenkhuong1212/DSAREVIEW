package w4;

import java.util.*;
import java.util.stream.Collectors;
import utils.Stack;

public class p3 {
    static class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }
    static class edgeList {
        Map<Character, ArrayList<Character>> list;

        public edgeList() {
            this.list = new HashMap<>();
        }

        void insert(Character u, Character v){
            ArrayList <Character> temp = list.get(u);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(v);
            list.put(u, temp);
            temp = list.get(v);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(u);
            list.put(v, temp);
        }

        ArrayList<Character> getAllEdgesOfAVertex(Character u){
            return list.get(u);
        }

        char[] getVertexList() {
            Set <Character> set = list.keySet();
            return set.stream().map(c -> Character.toString(c)).collect(Collectors.joining()).toCharArray();
        }

        Pair<Boolean, ArrayList<Character>> dfs(Character source, Character destination, ArrayList<Character> path){
            path.add(source);
            if (source == destination) return new Pair<>(true, path);
            ArrayList<Character> sourceEdges = getAllEdgesOfAVertex(source);
            for (Character vertex: sourceEdges){
                if (vertex == destination){
                    path.add(destination);
                    return new Pair<>(true, path);
                }
                if (!path.contains(vertex)){
                    Pair<Boolean, ArrayList<Character>> res = dfs(vertex, destination, path);
                    if (res.first) return res;
                }
            }
            path.remove(source);
            return new Pair<>(false, path);
        }

        void dfsTrace(ArrayList<Character> path){
            for (int i = 0; i < path.size() - 1; i++) {
                char element = path.get(i);
                System.out.print(element);
                System.out.print(" --> ");
            }
            System.out.println(path.get(path.size() - 1));
        }

        Stack<Character> bfs(char source, char destination){
            Map<Character, Character> pre = new HashMap<>();
            for (char ch: getVertexList()){
                pre.put(ch, ','); // initializing
            }
            pre.put(source, source);
            Stack<Character> queue = new Stack<>();
            queue.push(source);
            while (!queue.empty()){
                char u = queue.pop();
                for (char v: getAllEdgesOfAVertex(u)){
                    if (pre.get(v) != ',') continue;
                    pre.put(v, u);
                    queue.push(v);
                }
            }

            // Store the path for tracing
            char cur = destination;
            Stack<Character> st = new Stack<>();
            while (pre.get(cur) != cur){
                st.push(cur);
                cur = pre.get(cur);
                if (pre.get(cur) == null) break;
            }
            st.push(cur);
            return st;
        }

        void bfsTrace(Stack<Character> path, char destination){
            while (!path.empty()){
                if (path.size() == 1){
                    System.out.print(path.pop());
                    continue;
                }
                System.out.print(path.pop() + " --> ");
            }
        }
    }

    public static void main(String[] args) {
        edgeList eList = new edgeList();
        eList.insert('A', 'B');
        eList.insert('A', 'F');
        eList.insert('C', 'B');
        eList.insert('F', 'E');
        eList.insert('E', 'D');
        eList.insert('E', 'B');
        eList.insert('C', 'D');
        char source = 'A', destination = 'D';
        eList.dfsTrace(eList.dfs(source, destination, new ArrayList<>()).second);
        eList.bfsTrace(eList.bfs(source, destination), destination);
    }
}
