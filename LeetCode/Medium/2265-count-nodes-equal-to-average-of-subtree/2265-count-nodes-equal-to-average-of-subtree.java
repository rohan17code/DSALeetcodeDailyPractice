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
    private int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int nodes = left[1] + right[1] + 1;
        if(sum / nodes == root.val) cnt++;
        return new int[]{sum, nodes};
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }
}