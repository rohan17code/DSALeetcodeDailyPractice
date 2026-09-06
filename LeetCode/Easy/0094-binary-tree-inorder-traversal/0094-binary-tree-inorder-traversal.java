class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode ip = curr.left;
                while(ip.right != null && ip.right != curr) {
                    ip = ip.right;
                }
                if(ip.right == null) {
                    ip.right = curr;
                    curr = curr.left;
                } else {
                    ip.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }  
        return ans;      
    }
}