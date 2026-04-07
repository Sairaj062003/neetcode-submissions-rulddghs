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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dummy = new ListNode(-1);
       dummy.next = head;


       ListNode currentnode = head;
       ListNode prevnode = dummy;

       for(int i = 1 ; i< left ; i++){
        currentnode = currentnode.next;
        prevnode = prevnode.next;
       }

       ListNode sublist = currentnode;
       ListNode prevlist = null;

       for(int i =1 ; i<=right-left+1 ; i++){
        ListNode temp = sublist.next;
          sublist.next = prevlist;
          prevlist= sublist;
          sublist = temp;
       }
       currentnode.next = sublist;
       prevnode.next = prevlist;
     
     return dummy.next;
    }
    
}