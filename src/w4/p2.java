package w4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class p2 {
    static int[][] tree;
    public static int[] concatenate(int[] a, int[] b) {
        if (a == null) return b;
        if (b == null) return a;
        int aLen = a.length;
        int bLen = b.length;
        int[] res = new int[aLen + bLen];
        for (int i = 0, j = 0; i < aLen + bLen; i++, j++){
            res[i] = (i < aLen ? a[j] : b[j]);
            if (i >= aLen){
                j = 0;
            }
        }
        return res;
    }
    static class BSTNode{
        int data;
        BSTNode left = null;
        BSTNode right = null;

        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BSTNode(int data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(BSTNode left) {
            this.left = left;
        }

        public void setRight(BSTNode right) {
            this.right = right;
        }

        public void insert(BSTNode root, int data){
            BSTNode cur = root;
            BSTNode pre = null;
            while (cur != null){
                pre = cur;
                if (data < cur.data){
                    cur = cur.left;
                    continue;
                }
                cur = cur.right;
            }
            if (pre != null) {
                if (data < pre.data) {
                    pre.left = new BSTNode(data);
                }
                else {
                    pre.right = new BSTNode(data);
                }
            }
        }

        void iterateOverBST(BSTNode cur){
            if (cur == null){
                return;
            }
            int left = (cur.left == null ? -1 : cur.left.data);
            int right = (cur.right == null ? -1 : cur.right.data);
            System.out.println(cur.data + "; L: " + left + "; R:" + right);
            iterateOverBST(cur.left);
            iterateOverBST(cur.right);
        }

        void insertArrIntoBST(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                insert(this, arr[i]);
            }
        }

        void search(int data){
            BSTNode cur = this;
            int cmpcnt = 0;
            while (cur.data != data){
                cmpcnt++;
                if (data < cur.data){
                    cur = cur.left;
                    continue;
                }
                cur = cur.right;
            }
            System.out.println(cmpcnt);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 3, 1, 7, 9, 6, 5};
        BSTNode root = new BSTNode(4);
        root.insertArrIntoBST(arr);
        root.iterateOverBST(root);
        root.search(5);
        root.search(9);
    }
}
