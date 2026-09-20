class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                ans.add(list);
                list = new ArrayList<>();
                if(q.isEmpty()) break;
                else q.offer(null);

            } else {
                list.add(curr.val);
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return ans;
    }
}