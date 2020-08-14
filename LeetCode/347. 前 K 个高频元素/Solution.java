// 最小堆
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

    private class Freq implements Comparable<Freq> {
        // 记录元素和频次 作为类对象存入优先队列
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            // 频次低的话优先级高
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
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

        PriorityQueue<Freq> pq = new PriorityQueue<>();
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
