// 使用递归来解决
class Solution5 {
    public ListNode removeElements(ListNode head, int val) {

        // 对于空链表删除所有元素为val的节点，得到的还是空
        if (head == null)
            return null;
        // 将头节点后的链表中所有的val值删除后剩下的链表
        head.next = removeElements(head.next, val);
        // 三目运算符简写
        return (head.val == val) ? head.next : head;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = (new Solution5()).removeElements(list, 6);
        System.out.println(res);
    }
}

