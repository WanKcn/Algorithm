// 最小堆

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

    private class Freq {
        // 记录元素和频次 作为类对象存入优先队列
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 对nums中的频次进行统计
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = pq.remove().e;

        return arr;

    }
}
