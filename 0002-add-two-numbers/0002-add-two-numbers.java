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
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null;
        
        return prev;
        
    }
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        
        int carry = 0;
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        
        while(h1 != null || h2 != null){
            int sum = (h1 != null ? h1.val:0)+(h2 != null ?h2.val:0)+carry;
            
            int value = sum%10;
            carry = sum/10;
            dummy.next = new ListNode(value);
            dummy = dummy.next;
            
            if(h1!=null) h1=h1.next;
            if(h2 != null) h2=h2.next;
        }
        
        if(carry > 0){
            dummy.next = new ListNode(carry);
        }
        ListNode res = cur.next;
        
        return res;
    }
}