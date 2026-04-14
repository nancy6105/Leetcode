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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer>ans = new ArrayList<>();
        inorder(root,ans);
        int n = ans.size();
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<n;i++){
            int need = k - ans.get(i);
            if(mp.containsKey(need)){
                return true;
            }
            mp.put(ans.get(i),i);
        }
        return false;
    }
    void inorder(TreeNode root,ArrayList<Integer>ans){
        if(root == null)return;

        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}