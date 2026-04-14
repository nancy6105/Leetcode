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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        sol(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    void sol(TreeNode root){
        if(root == null)return;
        
        sol(root.left);
        if(prev!= null && prev.val > root.val){
            if(first == null){
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
        }
        prev = root;

        sol(root.right);
    }
}