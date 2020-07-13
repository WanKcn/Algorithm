public class LinearSearch {

    // 外界不可外部new 构造私有
    private LinearSearch() {
    }

    // 线性查找法
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) // 类对象判读值相等
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        // 测试找的到 返回下标
        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        // 测试找不到 返回-1
        int res2 = LinearSearch.search(data, 66);
        System.out.println(res2);

        // 测试学生类
        Student[] students = {new Student("zhangsan"),
                new Student("zhaosi"), new Student("wanger")};
        Student zhaosi = new Student("zhaosi");
        int res3 = LinearSearch.search(students, zhaosi);
        System.out.println(res3); // 返回-1 equals比较默认是两个类对象的地址
    }

}
