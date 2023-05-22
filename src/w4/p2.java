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
                    if (data == 1){
                        System.out.println("L");
//                        System.out.println(data + " " + pre.data + " " + cur.data);
                    }
                    continue;
                }
                cur = cur.right;
                if (data == 1){
                    System.out.println("R");
//                    System.out.println(data + " " + pre.data + " " + cur.data);
                }
            }
            if (pre.left == cur) {
                pre.left = new BSTNode(data);
            }
            else {
                pre.right = new BSTNode(data);
            }
        }

        int iterateOverBST(BSTNode root, int preData, int level){
            if (root == null){
                return 0;
            }
            System.out.println(preData + " " + root.data);
            return Math.max(Math.max(iterateOverBST(root.left, root.data, level + 1), iterateOverBST(root.right, root.data, level + 1)), level);
        }

        void printBST(){
            int maxLevel = iterateOverBST(this, 0,0);
            for (int i = 0; i < maxLevel; i++) {
                for (int arr : tree[i]) {
                    System.out.print(arr + " ");
                }
                System.out.println();
            }
        }

        BSTNode insertArrIntoBST(int[] arr) {
            BSTNode root = new BSTNode(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                insert(this, arr[i]);
            }
            return root;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 3, 1, 7, 9, 6, 5};
        BSTNode root = new BSTNode(4);
        root.insertArrIntoBST(arr);
        root.iterateOverBST(root, 0, 0);
    }
}
