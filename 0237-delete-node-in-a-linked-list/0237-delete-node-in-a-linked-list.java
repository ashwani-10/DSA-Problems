/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode thisNode = node;

        int temp = thisNode.val;
        thisNode.val = thisNode.next.val;
        thisNode.next.val = temp;

        thisNode.next = thisNode.next.next;
    }
}