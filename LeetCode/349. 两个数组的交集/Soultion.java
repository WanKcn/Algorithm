import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        // 将num1中的所有元素存入集合
        for (int n : nums1)
            set.add(n);
        // 此时集合set中有元素1，2
        ArrayList<Integer> list = new ArrayList<>();
        // 遍历nums2中元素
        for (int n : nums2) {
            // 如果集合中存在，说明找到了一个交集元素，把它另存到list中
            if (set.contains(n)) {
                list.add(n);
                // 从集合中删除该元素，以保证nums2中后续有相同元素重复存入list
                set.remove(n);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = new Solution().intersection(nums1, nums2);
        for (int n : res)
            System.out.print(n + " ");
    }
}