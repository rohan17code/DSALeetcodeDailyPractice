class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        for(int fr : friends) {
            set.add(fr);
        }
        int[] result = new int[friends.length];
        int idx = 0;
        for(int i = 0; i<order.length; i++) {
            if(set.contains(order[i])) {
                result[idx] = order[i];
                idx++;
            }
        }
        return result;
    }
}