import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0; // 记录个数
        int gi = g.length - 1;
        int si = s.length - 1;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            } else {
                // 不满足最贪心的小朋友，下一位小朋友
                gi--;
            }
        }

        return res;

    }
}