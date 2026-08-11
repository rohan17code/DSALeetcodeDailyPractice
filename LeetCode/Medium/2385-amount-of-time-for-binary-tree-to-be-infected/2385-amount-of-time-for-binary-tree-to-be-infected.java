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
    private TreeNode findStart(TreeNode root, int start) {
        if(root == null) return null;
        if(root.val == start) return root;
        TreeNode leftNodes = findStart(root.left, start);
        TreeNode rightNodes = findStart(root.right, start);
        if(leftNodes != null) {
            return leftNodes;
        }
        if(rightNodes != null) {
            return rightNodes;
        }
        return null;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParentPointer(root, parent);
        TreeNode startNode = findStart(root, start);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(startNode);
        visited.add(startNode);
        int time = 0;
        while(!q.isEmpty()) {
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
            time++;
        }
        return time - 1;
    }
}