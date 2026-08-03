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
    private int leftDepth(TreeNode root) {
        int dep = 0;
        while(root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }
    private int rightDepth(TreeNode root) {
        int dep = 0;
        while(root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }    
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if(leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}