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
    private int leftHeight(TreeNode root) {
        int h = 0;
        while(root != null) {
            root = root.left;
            h++;
        }
        return h;
    }
    private int rightHeight(TreeNode root) {
        int h = 0;
        while(root != null) {
            root = root.right;
            h++;
        }
        return h;
    }
    public int countNodes(TreeNode root) {
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if(leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}