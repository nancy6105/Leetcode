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
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kth = kth(temp,k);
            if(kth == null){
                if(prev!=null){
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kth.next;
            kth.next = null;
            reverse(temp);
            if(temp == head){
                head = kth;
            }
            else{
                prev.next = kth;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }

    ListNode kth(ListNode head,int k){
        k-=1;
        while(head!=null && k > 0){
            k--;
            head = head.next;
        }
        return head;      
    }
    ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }
        return prev;    
    }
}