class Solution {
    private int func(int[] weights, int capacity) {
        int day = 1, load = 0;
        for(int x: weights) {
            if(x + load > capacity) {
                day++;
                load = x;
            } else {
                load += x;
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int x : weights) {
            left = Math.max(left, x);
            right += x;
        }
        while(left <= right) {
            int mid = left + (right - left)/2;
            int No_ofDays = func(weights, mid);
            if(No_ofDays <= days) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }
}