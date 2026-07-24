class Solution {
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode mergeLL = new ListNode(0);
        ListNode temp = mergeLL;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        while(l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;            
        }
        while(l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;            
        }        
        return mergeLL.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(rightHead);
        return mergeList(newLeft, newRight);
    }
}