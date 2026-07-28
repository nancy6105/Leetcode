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
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null)return 0;

        return sol(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    int sol(TreeNode root,long target){
        if(root == null)return 0;
        
        int res = 0;
        if(root.val == target){
            res++;
        }
        res += sol(root.left,target-root.val);
        res += sol(root.right,target-root.val);
        return res;
    }
}