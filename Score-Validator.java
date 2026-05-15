1class Solution {
2    public int[] scoreValidator(String[] events) {
3    
4    int run =0;
5    int wickets=0;
6  for(int i =0;i<events.length;i++){
7       if(wickets<10){
8        switch (events[i]) {
9            case "1":
10                run +=1;
11                continue;
12            case "2":
13                run +=2;
14                continue;
15            case "3":
16                run +=3;
17                continue;
18            case "4":
19                run +=4;
20                continue;
21            case "6":
22                run +=6;
23                continue;  
24            case "W":
25                wickets +=1;
26                continue;
27            case "WD":
28                run +=1;
29                continue;
30            case "NB":
31                run +=1;
32                continue;
33        
34         }}
35       }
36    int[] arr = {run,wickets}; 
37    return arr;
38    }
39}