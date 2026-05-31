1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4
5        long planetMass = mass; // long use karo overflow avoid karne ke liye
6
7        for (int asteroid : asteroids) {
8            if (planetMass < asteroid) {
9                return false;
10            }
11            planetMass += asteroid;
12        }
13
14        return true;
15    }
16}