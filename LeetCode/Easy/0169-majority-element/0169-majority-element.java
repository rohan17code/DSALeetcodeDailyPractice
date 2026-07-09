class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        int ans = -1;
        for(int num : nums) {
            if(num == candidate) cnt++;
            else if(cnt == 0) {
                candidate = num;
                cnt = 1;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for(int num : nums) {
            if(num == candidate) cnt++;
            if(cnt > nums.length / 2) ans = candidate;
        }
        return ans;
    }
}