1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode detectCycle(ListNode head) {
14         
15         ListNode slow =head;
16         ListNode fast = head;
17
18         while(fast!=null && fast.next!=null){
19
20            slow=slow.next;
21            fast=fast.next.next;
22
23            if(slow==fast){
24               slow=head;
25            
26               while(slow != fast ){
27                    slow=slow.next;
28                    fast=fast.next;
29                }
30              return slow;
31            } 
32         }
33
34        
35        return null;
36
37    }
38}