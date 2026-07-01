class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] result = new int[nums.length * 2];
        int idx = 0;
        for(int num : nums) {
            result[idx] = num;
            idx++;
        }
        int idxx = nums.length;
        for(int i = nums.length - 1; i>=0; i--) {
            result[idxx] = nums[i];
            idxx++;
        }
        return result;
    }
}