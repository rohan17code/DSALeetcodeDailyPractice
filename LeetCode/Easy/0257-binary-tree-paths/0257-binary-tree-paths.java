class Solution {
    private void dfs(TreeNode root, String path, ArrayList<String> s) {
        if(root == null) return;
        if(path.length() == 0) {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }
        if(root.left == null && root.right == null) {
            s.add(path);
            return;
        }
        dfs(root.left, path, s);
        dfs(root.right, path, s);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> s = new ArrayList<>();
        dfs(root, "", s);
        return s;
    }
}