/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int height(TreeNode root) {
        if(root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH, rightH) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftNode = height(root.left);
        int rightNode = height(root.right);
        if(Math.abs(leftNode - rightNode) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}