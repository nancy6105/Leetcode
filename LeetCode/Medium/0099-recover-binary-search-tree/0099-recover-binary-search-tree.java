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
    public void recoverTree(TreeNode root) {
        ArrayList<Integer>arr = new ArrayList<>();
        inorder(root,arr);
        Collections.sort(arr);
        fixTree(root,arr,new int[] {0});
    }

    void fixTree(TreeNode root,ArrayList<Integer>arr,int idx[]){
        if(root == null)return;
        fixTree(root.left,arr,idx);
        root.val = arr.get(idx[0]++);
        fixTree(root.right,arr,idx);
    }

    void inorder(TreeNode root, ArrayList<Integer>arr){
        if(root == null)return;

        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}