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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        sol(root,0,0);
        sol(root,1,0);
        return max;
    }
    private void sol(TreeNode root,int dir,int len){
        if(root == null){
            return;
        }

        max = Math.max(max,len);
        //left
        if(dir == 0){
            sol(root.right,1,len+1);
            sol(root.left,0,1);
        }
        else{
            sol(root.left,0,len+1);
            sol(root.right,1,1);
        }
    }
}