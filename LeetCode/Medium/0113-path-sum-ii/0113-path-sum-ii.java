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
    private void dfs(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> ans) {
        if(root == null) return;
        path.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == targetSum) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum, sum, path, ans);
        dfs(root.right, targetSum, sum, path, ans);
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        dfs(root, targetSum, sum, path, ans);
        return ans;
    }
}