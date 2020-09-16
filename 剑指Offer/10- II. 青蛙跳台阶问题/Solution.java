import java.util.Arrays;

class Solution {
    public int numWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        return memo[n];
    }
}