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
12    public ListNode rotateRight(ListNode head, int k) {
13        
14        if(head ==null || head.next == null) 
15        return head;
16
17        int n =1;
18        ListNode last =head;
19
20        while(last.next!=null){
21            n++;
22            last = last.next;
23        }
24
25        k = k%n;
26
27        if(k==0)
28        return head;
29
30        int count = 1;
31        ListNode t = head;
32
33        while(t!=null){
34            if(count==(n-k)){
35                break;
36            }
37            count++;
38            t=t.next;
39        }
40        last.next = head;
41        ListNode res = t.next;
42        t.next= null;
43
44        return res;
45
46    }
47}