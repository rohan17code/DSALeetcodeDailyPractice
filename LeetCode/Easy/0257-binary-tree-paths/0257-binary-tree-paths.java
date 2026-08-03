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
    public void helper(TreeNode root, String path, List<String> s) {
        if(root == null) return;
        if(path.length() == 0) {
            path = ""+ root.val;
        } else {
            path = path + "->" + root.val;
        }
        if(root.left == null && root.right == null) {
            s.add(path);
            return;
        }
        helper(root.left, path, s);
        helper(root.right, path, s);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> s = new ArrayList<>();
        helper(root, "", s);
        return s;
    }
}