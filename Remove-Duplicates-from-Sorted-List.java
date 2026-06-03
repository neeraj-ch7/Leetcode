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
12    public ListNode deleteDuplicates(ListNode head) {
13         ListNode curr = head;
14
15        while (curr != null && curr.next != null) {
16            if (curr.val == curr.next.val) {
17                curr.next = curr.next.next; // remove duplicate
18            } else {
19                curr = curr.next; // move forward
20            }
21        }
22
23        return head;
24    }
25}