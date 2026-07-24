public class Solution {
    private int getLen(ListNode head) {
        int len = 1;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        while(lenA > lenB) {
            lenA--;
            headA = headA.next;
        }
        while(lenB > lenA) {
            lenB--;
            headB = headB.next;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}