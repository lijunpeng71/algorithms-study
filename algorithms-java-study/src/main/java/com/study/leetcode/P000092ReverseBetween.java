package com.study.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P000092ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newSubHead = null;
        ListNode newSubTail = null;
        for (int i = 0; i < left; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
