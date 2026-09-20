   class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0; 
        int max = Integer.MIN_VALUE;
        int lvl = 1;
        int maxLvl = 1;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                if(sum > max) {
                    max = sum;
                    maxLvl = lvl;
                }
                sum = 0;
                lvl++;
                if(q.isEmpty()) break;
                else q.offer(null);
            } else {
                sum += curr.val;
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return maxLvl;
    }
}