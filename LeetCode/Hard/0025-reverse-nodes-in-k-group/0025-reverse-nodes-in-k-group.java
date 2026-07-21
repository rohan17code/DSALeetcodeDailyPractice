class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for(int i = 0; i<k; i++) {
            if(temp == null) return head;
            temp = temp.next;
        }    
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        int cnt = 1;
        while(curr != null && k >= cnt) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}