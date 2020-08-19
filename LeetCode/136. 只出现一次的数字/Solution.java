class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int n:nums){
            ret^=n;
        }
        return ret;
    }
}