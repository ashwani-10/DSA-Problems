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
        if(head.next == null) return null;
        ListNode cur = head;
        int size = 0;
        
        while(cur != null){
            size++;
            cur = cur.next;
        }
        
        if(size == n)
            return head.next;
        
        ListNode tmp = head;
        int t = size-n-1;
        while(t > 0){
            tmp = tmp.next;
            t--;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}