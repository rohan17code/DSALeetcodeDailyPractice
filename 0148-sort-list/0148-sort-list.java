/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode mergeLL = new ListNode(-1);
        ListNode temp = mergeLL;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }
        while(h1 != null) {
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }
        while(h2 != null) {
            temp.next = h2;
            h2 = h2.next;
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
        return merge(newLeft, newRight);
    }
}