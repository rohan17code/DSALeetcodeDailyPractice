class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}