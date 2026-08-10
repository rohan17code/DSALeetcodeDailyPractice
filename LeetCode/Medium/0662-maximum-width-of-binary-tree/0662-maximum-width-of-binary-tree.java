class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int maxWidth = 0;
        while(!q.isEmpty()) {
            int currLvlSize = q.size();
            int stIdx = q.peekFirst().getValue();
            int endIdx = q.peekLast().getValue();
            maxWidth = Math.max(maxWidth, endIdx - stIdx + 1);
            for(int i = 0; i<currLvlSize; i++) {
                Pair<TreeNode, Integer> curr = q.poll();
                TreeNode node = curr.getKey();
                int idx = curr.getValue();
                if(node.left != null) {
                    q.offer(new Pair<>(node.left, 2 * idx + 1));
                }
                if(node.right != null) {
                    q.offer(new Pair<>(node.right, 2 * idx + 2));
                }
            }
        }
        return maxWidth;
    }
}