class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode ip = curr.left;
                while(ip.right != null) {
                    ip = ip.right;
                }
                ip.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }        
    }
}