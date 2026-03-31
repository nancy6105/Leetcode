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
    class Pair {
        TreeNode root;
        int x;
        int y;

        public Pair(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.root;
            int x = p.x;
            int y = p.y;

            if (!mp.containsKey(x)) {
                mp.put(x, new TreeMap<>());
            }

            if (!mp.get(x).containsKey(y)) {
                mp.get(x).put(y, new PriorityQueue<>());
            }

            mp.get(x).get(y).offer(node.val);
            if (node.left != null) {
                q.offer(new Pair(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> m : mp.values()) {
            List<Integer> l = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : m.values()) {
                while (!nodes.isEmpty()) {
                    l.add(nodes.poll());
                }
            }
            ans.add(l);
        }
        return ans;
    }
}