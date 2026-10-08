class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if(i == size - 1) ans.add(curr.val);
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);                
            }
        }
        return ans;
    }
}