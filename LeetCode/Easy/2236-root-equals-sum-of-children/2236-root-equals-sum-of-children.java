class Solution {
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        if(root.left.val + root.right.val == root.val) return true;
        return false;
    }
}