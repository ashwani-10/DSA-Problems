/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();

        Node temp = head;
        while(temp != null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node cn = map.get(temp);
            Node nn = map.get(temp.next);
            Node rn = map.get(temp.random);
            cn.next = nn;
            cn.random = rn;
            temp = temp.next;
        }
        Node cloneHead = map.get(head);

        return cloneHead;
    }
}