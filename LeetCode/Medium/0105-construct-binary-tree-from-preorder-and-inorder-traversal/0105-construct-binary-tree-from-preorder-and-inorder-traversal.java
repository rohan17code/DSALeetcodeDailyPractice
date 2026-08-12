class Solution {
    private TreeNode helper(int[] preorder, Map<Integer, Integer> inorderIdxMap, int preordRootIdx, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preordRootIdx]);
        int inorderRootIdx = inorderIdxMap.get(root.val);
        int leftSize = inorderRootIdx - left;
        if(inorderRootIdx > left) {
            root.left = helper(preorder, inorderIdxMap, preordRootIdx + 1, left, inorderRootIdx -1);
        }
        if(inorderRootIdx < right) {
            root.right = helper(preorder, inorderIdxMap, preordRootIdx + leftSize + 1, inorderRootIdx + 1, right);
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return helper(preorder, inorderIdxMap, 0, 0, inorder.length - 1);
    }
}