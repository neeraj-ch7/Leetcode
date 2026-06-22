1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseList(ListNode head) {
13        
14        ListNode curr = head;
15        ListNode prev = null;
16
17        while(curr!=null){
18            ListNode next = curr.next;
19            curr.next = prev;
20            prev = curr;
21            curr= next;
22        }
23        return prev;
24    }
25}