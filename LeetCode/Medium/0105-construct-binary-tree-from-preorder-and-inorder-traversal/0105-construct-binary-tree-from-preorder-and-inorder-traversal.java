class Solution {
    private int preIdx = 0;
    private int search(int[] inorder, int left, int right, int val) {
        for(int i = left; i<=right; i++) {
            if(inorder[i] == val) return i;
        }
        return -1;
    }
    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        int inoIdx = search(inorder, left, right, root.val);
        root.left = helper(preorder, inorder, left, inoIdx - 1);
        root.right = helper(preorder, inorder, inoIdx + 1, right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}