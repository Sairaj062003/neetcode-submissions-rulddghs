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

        if( head == null){
            return null;

        }
        int size = 0;
        ListNode node = head;

        while( node != null){
            size++;
            node = node.next;
        }

      
      int index = size - n;
      ListNode prenode =   get(head , index-1);
      
        if( n == size){
            return head.next;

        }
      prenode.next = prenode.next.next;
      
      return head;
          }

    private ListNode get(ListNode head,int index){
        
        ListNode temp = head;

        for(int i = 0 ; i< index ;i++){
            temp = temp.next;
        }

        return temp;

    } 
}
