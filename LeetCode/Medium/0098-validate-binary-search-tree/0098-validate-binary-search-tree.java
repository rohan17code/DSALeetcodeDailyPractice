class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    public boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && min.val >= root.val) return false;
        if(max != null && max.val <= root.val) return false;
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}