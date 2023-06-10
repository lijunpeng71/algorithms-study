package com.xuelianyong.study.leetcode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P000025_ReverseKGroup {

    /**
     * 递归方法
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup01(ListNode head, int k) {
        ListNode nextHead = head;
        int remainNum = 0;
        while (remainNum < k) {
            if (nextHead == null) {
                return head;
            }
            remainNum++;
            nextHead = nextHead.next;
        }
        ListNode subList = reverseKGroup01(nextHead, k);
        ListNode newHead = reverseListNode(head, k);
        head.next = subList;
        return newHead;
    }

    private static ListNode reverseListNode(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode list = new ListNode(arr);
        list = reverseKGroup01(list, 2);
        while (list != null) {
            System.out.print(list.val + "\t");
            list = list.next;
        }
        System.out.println();
    }
}
