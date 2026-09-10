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
    private int ansMax = -1;
    private void dfs(TreeNode curr, int max, int min) {
        if(curr == null) return;
        if(curr.val >= max) {
            max = Math.max(max, curr.val);
        }
        if(curr.val < min) {
            min = Math.min(min, curr.val);
        }
        ansMax = Math.max(ansMax, Math.abs(max - min));
        dfs(curr.left, max, min);
        dfs(curr.right, max, min);
    }
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ansMax;
    }
}