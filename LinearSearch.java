public class LinearSearch {

    // 外界不可外部new 构造私有
    private LinearSearch() {
    }

    // 线性查找法
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        // 测试找的到 返回下标
        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        // 测试找不到 返回-1
        int res2 = LinearSearch.search(data, 66);
        System.out.println(res2);

    }

}
