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
    public void reorderList(ListNode head) {

           ListNode fast = head ;

           ListNode slow = head; 

           while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
           }

           ListNode midnode = slow.next;
           
           ListNode preNode = slow.next = null;

           while(midnode !=  null){
            ListNode temp = midnode.next;
            midnode.next = preNode;
            preNode = midnode;
            midnode = temp;
           }

           ListNode p1 = head;
           midnode = preNode;

           while( midnode != null ){
            ListNode temp1 = p1.next;
            ListNode temp2 = midnode.next;
            p1.next = midnode;
            midnode.next = temp1;
            p1 = temp1;
            midnode = temp2;
           }


    }
}
