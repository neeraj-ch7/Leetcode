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
12    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
13
14        ListNode dummy = new ListNode(-1);
15        ListNode tail = dummy;
16
17        while (list1 != null && list2 != null) {
18
19            if (list1.val <= list2.val) {
20                tail.next = list1;
21                list1 = list1.next;
22            } else {
23                tail.next = list2;
24                list2 = list2.next;
25            }
26
27            tail = tail.next;
28        }
29
30        // Remaining nodes attach kar do
31        if (list1 != null) {
32            tail.next = list1;
33        } else {
34            tail.next = list2;
35        }
36
37        return dummy.next;
38    }
39}