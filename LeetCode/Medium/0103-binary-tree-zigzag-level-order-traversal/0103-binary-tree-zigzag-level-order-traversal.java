class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean oddLvl = true;
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if(oddLvl) {
                    list.addLast(curr.val);
                } else {
                    list.addFirst(curr.val);
                }
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            oddLvl = !oddLvl;
            ans.add(list);
        }
        return ans;
    }
}