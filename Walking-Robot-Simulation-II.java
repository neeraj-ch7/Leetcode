1class Robot {
2
3    int width, height;
4    int x, y;
5    int dir; // 0 = East, 1 = North, 2 = West, 3 = South
6    int perimeter;
7
8    public Robot(int width, int height) {
9        this.width = width;
10        this.height = height;
11        this.x = 0;
12        this.y = 0;
13        this.dir = 0; // East
14        this.perimeter = 2 * (width + height) - 4;
15    }
16
17    public void step(int num) {
18        num %= perimeter;
19
20        // Special case: full cycle
21        if (num == 0) {
22            if (x == 0 && y == 0) {
23                dir = 3; // South
24            }
25            return;
26        }
27
28        while (num > 0) {
29            if (dir == 0) { // East
30                int move = Math.min(num, width - 1 - x);
31                x += move;
32                num -= move;
33                if (num > 0) {
34                    dir = 1; // turn North
35                }
36            } else if (dir == 1) { // North
37                int move = Math.min(num, height - 1 - y);
38                y += move;
39                num -= move;
40                if (num > 0) {
41                    dir = 2; // turn West
42                }
43            } else if (dir == 2) { // West
44                int move = Math.min(num, x);
45                x -= move;
46                num -= move;
47                if (num > 0) {
48                    dir = 3; // turn South
49                }
50            } else { // South
51                int move = Math.min(num, y);
52                y -= move;
53                num -= move;
54                if (num > 0) {
55                    dir = 0; // turn East
56                }
57            }
58        }
59    }
60
61    public int[] getPos() {
62        return new int[]{x, y};
63    }
64
65    public String getDir() {
66        if (dir == 0) return "East";
67        if (dir == 1) return "North";
68        if (dir == 2) return "West";
69        return "South";
70    }
71}
72/**
73 * Your Robot object will be instantiated and called as such:
74 * Robot obj = new Robot(width, height);
75 * obj.step(num);
76 * int[] param_2 = obj.getPos();
77 * String param_3 = obj.getDir();
78 */