class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '*') {
                dq.removeLast();
            }    
            else {
                dq.addLast(s.charAt(i));
            }    
        }
        while(!dq.isEmpty()) {
            sb.append(dq.removeFirst());
        }
        return sb.toString();
    }
}