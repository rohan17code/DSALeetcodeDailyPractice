class Solution {
    private TreeNode helper(int[] postorder, Map<Integer, Integer> inorderIdxMap, int postordRoot, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode(postorder[postordRoot]);
        int inorderRootIdx = inorderIdxMap.get(root.val);
        int RightSize = right - inorderRootIdx;
        if(inorderRootIdx < right) {
            root.right = helper(postorder, inorderIdxMap, postordRoot - 1, inorderRootIdx + 1, right);
        }
        if(inorderRootIdx > left) {
            root.left = helper(postorder, inorderIdxMap, postordRoot - RightSize - 1, left, inorderRootIdx - 1);
        }
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        return helper(postorder, inorderIdxMap, postorder.length - 1, 0, inorder.length - 1);
    }
}