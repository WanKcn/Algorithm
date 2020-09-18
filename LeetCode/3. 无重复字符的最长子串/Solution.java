class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1;  // 滑动窗口[l..r]
        int res = 0;
        int[] freq = new int[256];
        while (l < s.length()) {
//            if (freq[s.charAt(r + 1)] == 0 && r + 1 < s.length())非法
            // r + 1 < s.length()的判断必须在前面防止越界
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0 )
                freq[s.charAt(++r)]++;
            else
                freq[s.charAt(l++)]--;

            res = Math.max(res, r - l + 1);
        }

        return res;

    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }
}