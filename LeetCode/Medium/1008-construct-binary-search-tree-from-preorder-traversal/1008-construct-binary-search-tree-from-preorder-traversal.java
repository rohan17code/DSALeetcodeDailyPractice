class Solution {
    int i = 0;
    private TreeNode helperDfs(int[] preorder, int bound) {
        if(i >= preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        root.left = helperDfs(preorder, root.val);
        root.right = helperDfs(preorder, bound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helperDfs(preorder, Integer.MAX_VALUE);        
    }
}