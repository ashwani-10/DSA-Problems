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
    public ListNode reverseList(ListNode head,ListNode tail){
        ListNode prev = null;
        ListNode cur = head;

        while(cur!=tail){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;

        for(int i=0;i<k;i++){
            if(temp == null) return head;
            temp = temp.next;
        }

        ListNode newHead = reverseList(head,temp);

        head.next = reverseKGroup(temp,k);

        return newHead;
    }
}