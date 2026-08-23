class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    private void storeLeftNodes(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        storeLeftNodes(root);
    }
    
    public int next() {
        TreeNode ans = s.peek();
        s.pop();
        storeLeftNodes(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */