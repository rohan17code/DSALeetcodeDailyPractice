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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) {
            return zigzag;
        }    
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> lvl = new LinkedList<>();
            for(int i = 0; i<size; i++) {
                TreeNode currNode = q.poll();
                if(leftToRight) {
                    lvl.addLast(currNode.val);
                } else {
                    lvl.addFirst(currNode.val);
                }
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            leftToRight = !leftToRight;
            zigzag.add(lvl);
        }
        return zigzag;
    }
}