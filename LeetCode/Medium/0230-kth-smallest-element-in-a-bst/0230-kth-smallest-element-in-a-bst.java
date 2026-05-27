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
    ArrayList<Integer> arr;
    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();
        collect(root);
        Collections.sort(arr);
        return arr.get(k-1);
    }
    void collect(TreeNode root){
        if(root == null)return;
        arr.add(root.val);
        collect(root.left);
        collect(root.right);
    }
}