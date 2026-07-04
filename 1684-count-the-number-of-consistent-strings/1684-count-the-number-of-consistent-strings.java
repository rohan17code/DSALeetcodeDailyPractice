class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int cnt = 0;
        for(int i = 0; i<words.length; i++) {
            String w = words[i];
            int flag = 1;
            for(int j = 0; j<w.length(); j++) {
                if(!set.contains(w.charAt(j))) {
                    flag = 0;
                    break;
                }
            }
            cnt += flag;
        }
        return cnt;
    }
}