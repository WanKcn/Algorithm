
// 大神代码 位运算

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for(int num : nums) {
        	a = (a ^ num) & ~b;
        	b = (b ^ num) & ~a;
        }
        return a;
    }
}