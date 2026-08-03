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
    int sum = 0;
    public void helper(TreeNode root, int currNum) {
        if(root == null) return;
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right== null) {
            sum += currNum;
            return;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}