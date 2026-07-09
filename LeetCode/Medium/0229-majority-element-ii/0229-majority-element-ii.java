class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Integer x : map.keySet()) {
            if(map.get(x) > nums.length / 3) {
                result.add(x);
            }
        }
        return result;
    }
}