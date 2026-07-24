class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }   
        k = k % len;     
        temp.next = head;
        int step = len - k - 1;
        ListNode temp2 = head;
        while(step > 0) {
            temp2 = temp2.next;
            step--;
        }
        ListNode newHead = temp2.next;
        temp2.next = null;
        return newHead;
    }
}