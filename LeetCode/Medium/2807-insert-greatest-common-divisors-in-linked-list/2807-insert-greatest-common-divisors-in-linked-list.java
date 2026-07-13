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
    public int getGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode next;
        while(curr != null && curr.next != null) {
            next = curr.next;
            int gcd = getGCD(curr.val, next.val);
            ListNode newNode = new ListNode(gcd);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        return head;
    }
}