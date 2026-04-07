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
    public ListNode reverseList(ListNode head) {
        ListNode currentnode = head;
        ListNode prevnode = null;

        while(currentnode!=null){
              ListNode temp = currentnode.next;
              currentnode.next = prevnode;
              prevnode = currentnode;
              currentnode = temp;
              
        }
          
        return prevnode;
            
    }
}
