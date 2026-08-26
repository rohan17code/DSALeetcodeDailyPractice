class Solution {
    private void getInorder(TreeNode root, ArrayList<Integer> inorder) {
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }
    private TreeNode createBST(ArrayList<Integer> inorder, int st, int end) {
        if(st > end) return null;
        int mid = (st + end) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }
}