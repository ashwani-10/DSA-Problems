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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        ListNode cur = head;

        while(cur != null){
            st.push(cur);
            cur = cur.next;
        }

        cur = st.pop();
        int maximum = cur.val;
        ListNode res = new ListNode(maximum);

        while(!st.isEmpty()){
            cur = st.pop();
            if(cur.val < maximum){
                continue;
            }
            ListNode newNode = new ListNode(cur.val);
            newNode.next = res;
            res = newNode;
            maximum = cur.val;
        }
        return res;
    }
}