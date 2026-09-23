class Solution {
    private void makeParentPointer(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParentPointer(root, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.offer(target);
        vis.add(target);
        int dist = 0;
        while(!q.isEmpty()) {
            if(dist == k) break;
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && !vis.contains(curr.left)) {
                    q.offer(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right)) {
                    q.offer(curr.right);
                    vis.add(curr.right);
                }
                TreeNode p = parent.get(curr);
                if(p != null && !vis.contains(p)) {
                    q.offer(p);
                    vis.add(p);
                }
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}