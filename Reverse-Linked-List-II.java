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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        
14        if(head==null){
15            return null;
16        }
17        if(left==right){
18            return head;
19        }
20        ListNode t= head;
21        ListNode before = null;
22        int pos =1;
23
24        
25            while(pos<left){
26                before = t;
27                t=t.next;
28                pos++;
29            
30            }
31            //pos == left
32
33            ListNode curr = t;
34            ListNode prev =null;
35            int times = right -left +1;
36
37            while(times!=0){
38                ListNode next = curr.next;
39                curr.next = prev;
40                prev =curr;
41                curr =next;
42                times--;
43            }
44            t.next = curr;
45            if(before!=null){
46                before.next = prev;
47                return head;
48            }
49            return prev;
50        }
51    }