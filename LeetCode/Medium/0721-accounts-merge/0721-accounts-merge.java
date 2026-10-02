class Solution {
    static int[] par;
    static int[] rank;
    private static void init(int n) {
        for(int i = 0; i<n; i++) {
            par[i] = i;
        }
    }
    private static int find(int x) {
        if(x == par[x]) return x;
        return par[x] = find(par[x]);
    }
    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else par[parB] = parA;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        rank = new int[n];
        init(n);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            for(int j = 1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(i, map.get(email));
                }
            }
        }
        Map<Integer, ArrayList<String>> merged = new HashMap<>();
        for(String email : map.keySet()) {
            int parent = find(map.get(email));
            if(!merged.containsKey(parent)) {
                merged.put(parent, new ArrayList<>());
            }
            merged.get(parent).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            if(merged.containsKey(i)) {
                ArrayList<String> Emails = merged.get(i);
                Collections.sort(Emails);
                ArrayList<String> account = new ArrayList<>();
                account.add(accounts.get(i).get(0));
                account.addAll(Emails);
                ans.add(account);
            }
        }
        return ans;
    }
}