class Solution {
    private int leftH(TreeNode root) {
        int h = 0;
        while(root != null) {
            root = root.left;
            h++;
        }
        return h;
    }
    private int rightH(TreeNode root) {
        int h = 0;
        while(root != null) {
            root = root.right;
            h++;
        }
        return h;
    }
    public int countNodes(TreeNode root) {
        int leftH = leftH(root);
        int rightH = rightH(root);
        if(leftH == rightH) {
            return (int) Math.pow(2, leftH) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}