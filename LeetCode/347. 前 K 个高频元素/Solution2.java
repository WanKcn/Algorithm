// 最小堆

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // 对nums中的频次进行统计
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(key);
            else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = pq.remove();

        return arr;

    }
}
