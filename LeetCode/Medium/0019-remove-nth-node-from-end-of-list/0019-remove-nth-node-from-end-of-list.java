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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        if(n == size) {
            head = head.next;
            return head;
        }
        int i = 1;
        int nthPrevNode = size - n;
        ListNode curr = head;
        while(i < nthPrevNode) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }
}