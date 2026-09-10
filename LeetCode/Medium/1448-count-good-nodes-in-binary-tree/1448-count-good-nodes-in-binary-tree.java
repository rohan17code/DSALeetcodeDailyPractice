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
    private int cnt = 0;
    private void dfs(TreeNode curr, int max) {
        if(curr == null) return;
        if(curr.val >= max) {
            cnt++;
        }
        max = Math.max(max, curr.val);
        dfs(curr.left, max);
        dfs(curr.right, max); 
    }
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return cnt;
    }
}