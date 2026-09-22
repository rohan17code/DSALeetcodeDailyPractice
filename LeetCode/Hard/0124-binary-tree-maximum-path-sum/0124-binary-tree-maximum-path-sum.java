class Solution {
    int max = Integer.MIN_VALUE;
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        int sum = left + right + root.val;
        max = Math.max(max, sum);
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}