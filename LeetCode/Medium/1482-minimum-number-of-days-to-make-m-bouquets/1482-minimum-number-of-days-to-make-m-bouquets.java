class Solution {
    private boolean possible(int[] arr, int day, int m, int k) {
        int cnt = 0;
        int noOfBloom = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] <= day) {
                cnt++;
            } else{
                noOfBloom += (cnt/k);
                cnt = 0;
            }
        }
        noOfBloom += (cnt/k);
        return noOfBloom >= m;
    }
    public int minDays(int[] arr, int m, int k) {
        long edgeCase = (long) m *  k;
        if(edgeCase > arr.length) return - 1;
        int left = 0, right = 0;
        for(int x : arr) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }
        while(left <= right) {
            int mid = left+(right - left)/2;
            if(possible(arr, mid, m, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}