import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            // 把i点当作三元素第一个点，记录每一个点到i点的距离。map(distance,freq)
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 计算两点之间的距离
                    int dis = distance(points[i], points[j]);
                    if (!map.containsKey(dis))
                        map.put(dis, 1);
                    else
                        map.put(dis, map.get(dis) + 1);
                }
            }

            for (int freq : map.values())
                // 选择组合一共有n*(n-1)种 频次>=2 频次=1省略 1-1 =0 任何数乘以0都为0
                res += freq * (freq - 1);

        }

        return res;

    }

    private static int distance(int[] points1, int[] points2) {
        // 距离不开平方根，避免因为开方浮点数造成精度丢失 两点之间的距离的平方也是一样的
        return (points1[0] - points2[0]) * (points1[0] - points2[0])
                + (points1[1] - points2[1]) * (points1[1] - points2[1]);
    }
}