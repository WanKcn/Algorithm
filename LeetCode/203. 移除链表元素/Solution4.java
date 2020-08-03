// 使用递归来解决
class Solution4 {
    public ListNode removeElements(ListNode head, int val) {

        // 对于空链表删除所有元素为val的节点，得到的还是空
        if (head == null)
            return null;
        // 将头节点后的链表中所有的val值删除后剩下的链表
        ListNode res = removeElements(head.next, val);
        // 判断头节点的值是否为val
        if (head.val == val)
            return res;
        // head的值不为val时候返回head和后面的链表
        else {
            // 让head挂接上后面的链表
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = (new Solution4()).removeElements(list, 6);
        System.out.println(res);
    }
}

