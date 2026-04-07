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
    public ListNode reverseKGroup(ListNode head, int k) {
      
      ListNode dummy =  new ListNode(0,head);
       

       ListNode prevnode = dummy;

       while(true){
        ListNode kth = getNode(prevnode,k);
        
        if(kth == null){
            break;
        }

         ListNode groupNext= kth.next;;
         ListNode prevlist = kth.next;
         
          ListNode sublist = prevnode.next;
           ListNode sublistHead = sublist;

          while(sublist != groupNext){
            ListNode temp = sublist.next;
            sublist.next=prevlist;
            prevlist=sublist;
            sublist = temp;
          }
       
       prevnode.next = kth;
       prevnode = sublistHead;
     
            

       }
        
      return dummy.next;  
    }

    private ListNode getNode( ListNode current , int k){
        while(current != null && k>0){
            current = current.next;
            k--;
        }
        return current;
    }
}
