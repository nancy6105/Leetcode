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
    int preidx = 0;
    Map<Integer,Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int left,int right){
        if(left > right){
            return null;
        }
        int rootval = preorder[preidx++];
        TreeNode root = new TreeNode(rootval);

        int mid = mp.get(rootval);

        root.left = build(preorder,left,mid-1);
        root.right = build(preorder,mid+1,right);
        return root;
    }
}