package w4;

public class p1 {
    class treeNode{
        String data;
        treeNode left;
        treeNode right;

        public treeNode(String data, treeNode left, treeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int height(){
            int maxHeight = 0;
            if (left != null){
                maxHeight = Math.max(maxHeight, left.height());
            }
            if (right != null){
                maxHeight = Math.max(maxHeight, right.height());
            }
            return maxHeight + 1;
        }
    }
}
