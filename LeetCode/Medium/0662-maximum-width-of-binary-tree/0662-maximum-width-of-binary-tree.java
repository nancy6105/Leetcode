/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode root;
        long index;

        public Pair(TreeNode root,long index){
            this.root = root;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        long max = 0;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            long min = q.peek().index;
            long first = 0;
            long last = 0;

            for(int i = 0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.root;
                long currIdx = p.index - min;

                if(i == 0){
                    first = currIdx;
                }
                if(i == size-1){
                    last = currIdx;
                }

                if(node.left != null){
                    q.offer(new Pair(node.left,2*currIdx+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right,2*currIdx+2));
                }
            }
            max = Math.max(max,last-first+1);
        }
        return (int)max;
    }
}