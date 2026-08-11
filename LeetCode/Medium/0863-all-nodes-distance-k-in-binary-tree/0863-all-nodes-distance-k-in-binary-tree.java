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
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int dist = 0;
        while(!q.isEmpty()) {
            if(dist == k) break;
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                TreeNode p = parent.get(curr);
                if(p != null && !visited.contains(p)) {
                    q.offer(p);
                    visited.add(p);
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