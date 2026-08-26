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
    private TreeNode createBst(int[] num , int st, int end) {
        if(st > end) return null;
        int mid = (st + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = createBst(num, st, mid - 1);
        root.right = createBst(num , mid + 1, end); 
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBst(nums, 0, nums.length - 1);
    }
}