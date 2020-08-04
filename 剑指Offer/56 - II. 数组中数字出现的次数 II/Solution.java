class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int n: nums){
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n,map.get(n)+1);
        }
        for(int n:nums){
            if(map.get(n)==1)
            	return n;
        }
        return -1;
    }
}