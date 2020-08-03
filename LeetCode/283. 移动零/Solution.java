class Solution {
    public void moveZeroes(int[] nums) {
        int tag = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[tag] = nums[i];
                tag++;
            }
        }
        for(int i = tag;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}