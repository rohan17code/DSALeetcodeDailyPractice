class Solution {

    // column -> level -> values
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        // Fill the map using DFS
        dfs(root, 0, 0);

        // TreeMap automatically gives columns in sorted order
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry
                : map.entrySet()) {

            TreeMap<Integer, ArrayList<Integer>> levelMap = entry.getValue();

            ArrayList<Integer> list = new ArrayList<>();

            // Levels are also automatically sorted
            for (ArrayList<Integer> values : levelMap.values()) {

                // Same column + same level
                // -> smaller value first
                Collections.sort(values);

                list.addAll(values);
            }

            ans.add(list);
        }

        return ans;
    }

    public void dfs(TreeNode root, int col, int level) {

        if (root == null) return;

        // Create column if it doesn't exist
        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }

        // Create level if it doesn't exist
        if (!map.get(col).containsKey(level)) {
            map.get(col).put(level, new ArrayList<>());
        }

        // Put node value
        map.get(col).get(level).add(root.val);

        // Left -> column - 1
        dfs(root.left, col - 1, level + 1);

        // Right -> column + 1
        dfs(root.right, col + 1, level + 1);
    }
}