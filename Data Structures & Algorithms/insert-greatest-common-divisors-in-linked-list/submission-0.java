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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head ==null) return null;

        ListNode node = head;

        while(node.next != null){
            int d1 = node.val ; 
            int d2 = node.next.val;

            int num = gcd(d1,d2);
            ListNode newnode = new ListNode(num,node.next);
            node.next= newnode;
            node=newnode.next;
        }

        return head;
    }
    private int  gcd(int a , int b){
        return b==0 ? a:gcd(b,a % b);
    }
}