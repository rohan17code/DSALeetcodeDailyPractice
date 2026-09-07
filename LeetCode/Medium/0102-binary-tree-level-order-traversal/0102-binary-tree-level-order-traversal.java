class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> lvlOrd = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                ans.add(lvlOrd);
                lvlOrd = new ArrayList<>();
                if(q.isEmpty()) break;
                else q.add(null);
            } else {
                lvlOrd.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}