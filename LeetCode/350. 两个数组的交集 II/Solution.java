import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 第一个Interger代表元素，第二个Interger代表出现的频次
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // 对num1数组进行遍历
        for (int n : nums1) {
            // 如果在映射中不包含n,为map中新增元素
            if (!map.containsKey(n))
                map.put(n, 1); // 新增元素频次默认为1
            else // 如果包含，则为n的频次+1
                map.put(n, map.get(n) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(); // 用于存放交集元素
        // 遍历num2数组处理交集问题
        for (int n : nums2) {
            // 如果包含，则找到了一个交集元素
            if (map.containsKey(n)) {
                list.add(n);
                // 由于映射中存储的是频次，找到一个元素，将频次-1
                map.put(n, map.get(n) - 1);
                // 如果发现n的频次-1之后等于0 则将它从映射中删除
                if (map.get(n) == 0)
                    map.remove(n);
            }
            // 如果不包含，什么也不做，说明一定不是并集元素
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 9, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = new Solution().intersect(nums1, nums2);
        for (int n : res)
            System.out.print(n + " ");
    }
}