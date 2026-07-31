class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];   // nums.length - k + 1 is no. of sliding window...so jitni SW utna hi result ka size 
        int idx = 0;

        // 1st window
        for(int i = 0; i<k; i++) {
            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        for(int i = k; i<nums.length; i++) {
            result[idx] = (nums[dq.peekFirst()]);
            idx++;
            // remove not part of curr window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // remove the smaller values
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);            
        }
        result[idx++] = (nums[dq.getFirst()]);
        return result;
    }
}