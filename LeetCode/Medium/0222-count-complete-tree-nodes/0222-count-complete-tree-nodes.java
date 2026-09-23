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
        if(root == null) return 0;
        int left = leftH(root);
        int right = rightH(root);
        if(left == right) {
            return (int) Math.pow(2, left) - 1;
        }
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
}