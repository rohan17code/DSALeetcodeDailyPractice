class Solution {
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        dfs(root, 0, 0);

        for(Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, ArrayList<Integer>> levelMap = entry.getValue();
            ArrayList<Integer> list = new ArrayList<>();
            for(ArrayList<Integer> value: levelMap.values()) {
                Collections.sort(value);
                list.addAll(value);
            }
            ans.add(list);
        }
        return ans;
    }

        public void dfs(TreeNode root, int col, int level) {
            if(root == null) return;

            if(!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if(!map.get(col).containsKey(level)) {
                map.get(col).put(level, new ArrayList<>());
            }
            map.get(col).get(level).add(root.val);
            dfs(root.left, col - 1, level + 1);
            dfs(root.right, col + 1, level + 1);
        }

}