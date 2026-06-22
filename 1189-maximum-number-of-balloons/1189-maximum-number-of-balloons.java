class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<text.length(); i++) {
            char ch = text.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int b = map.getOrDefault('b', 0);    // freq of b
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);   
        int ans = Math.min(a,
            Math.min(b,
            Math.min(l,
            Math.min(o,n))));
        return ans;
    }
}