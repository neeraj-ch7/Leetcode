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
12
13    ListNode reverse(ListNode head, int times){
14        ListNode curr = head;
15        ListNode prev = null;
16
17        while(times > 0 && curr != null){
18            ListNode next = curr.next;
19            curr.next = prev;
20            prev = curr;
21            curr = next;
22            times--;
23        }
24
25        return prev;
26    }
27
28    public ListNode reverseKGroup(ListNode head, int k) {
29
30        int size = k;
31
32        ListNode left = head;
33        ListNode right;
34        ListNode prevleft = null;
35        ListNode res = null;
36
37        while(true){
38
39            right = left;
40
41            for(int i = 0; i < size - 1; i++){
42                if(right == null){
43                    break;
44                }
45                right = right.next;   // left.next nahi
46            }
47
48            if(right != null){
49
50                ListNode nextleft = right.next;
51
52                right= reverse(left, size);
53
54                if(prevleft != null){
55                    prevleft.next = right;
56                }
57
58                left.next = nextleft;
59
60                prevleft = left;
61
62                if(res == null){
63                    res = right;
64                }
65
66                left = nextleft;
67            }
68            else{
69
70                if(prevleft != null){
71                    prevleft.next = left;
72                }
73
74                if(res == null){
75                    res = left;
76                }
77
78                break;
79            }
80        }
81
82        return res;
83    }
84}