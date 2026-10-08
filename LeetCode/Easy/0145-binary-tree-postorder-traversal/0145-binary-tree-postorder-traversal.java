class Solution {
    private void dfs(TreeNode root, ArrayList<Integer> ans) {
        if(root == null) return;
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
}