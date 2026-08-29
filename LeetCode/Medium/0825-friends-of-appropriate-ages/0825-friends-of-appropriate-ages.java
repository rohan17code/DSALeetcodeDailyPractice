class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for(int age : ages) {
            freq[age]++;
        }
        int cnt = 0;
        for(int i = 1; i <= 120; i++) {
            if(freq[i] == 0) continue;
            for(int j = 1; j <= 120; j++) {
                if(freq[j] == 0) continue;
                if(j <= 0.5 * i + 7) continue;
                if(j > i) continue;
                if(j > 100 && i < 100) continue;
                cnt += freq[i] * freq[j];
                if(i == j) cnt-= freq[i];
            }
        }
        return cnt;
    }
}