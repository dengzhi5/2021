package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTopic {
    public static void main(String[] args) {
        //两数之和
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode lc = new ListNode(8, null);
        ListNode lb = new ListNode(6, lc);
        ListNode la = new ListNode(4, lb);
        //addTwoNumbers(l1, la);
        //addTwoNumbers2(l1, la);

        //删除链表的倒数第 N 个结点
        //removeNthFromEnd(l1, 5);
        //removeNthFromEnd2(l1, 2);

        //反转链表
        //reverseList(l1);

        //合并两个有序链表
        mergeTwoLists(l1, la);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode la) {
        ListNode res = new ListNode(0);
        ListNode resTemp = res;
        while (la != null && l1 != null){
                if(la.val>=l1.val){
                    resTemp.next = l1;
                    resTemp = resTemp.next;
                    l1=l1.next;
                }else {
                    resTemp.next = la;
                    resTemp = resTemp.next;
                    la = la.next;
                }

            }
        resTemp.next = l1 != null ? l1 : la;
        return res.next;
    }

    private static ListNode reverseList(ListNode l1) {
        ListNode prev = null;
        ListNode curr = l1;
        while (curr != null) {
            ListNode next = curr.next;//a =  b.next
            curr.next = prev;//b.next = c
            prev = curr;//c = b
            curr = next;//b = a
        }
        return prev;
    }

    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode resTemp = head;
        ListNode sec = res;
        for (int i = 0; i < n; i++) {
            resTemp = resTemp.next;
        }
        while (resTemp != null) {
            resTemp = resTemp.next;
            res = res.next;
        }
        res.next = res.next.next;
        return sec;
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        ListNode resTemp = res;
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.remove(list.size() - n);
        if (list.size() <= 0) {
            return null;
        }
        for (Integer integer : list) {
            if (resTemp == null || resTemp.val < 0) {
                resTemp.val = integer;
            } else {
                resTemp.next = new ListNode(integer);
                resTemp = resTemp.next;
            }
        }
        return res;
    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode la) {
        int flag = 0;
        ListNode res = new ListNode();
        ListNode resTemp = res;
        int nextNum = 0;
        int p;
        while (l1 != null && la != null) {
            if (flag == 0) {
                p = la.val + l1.val;
                res.val = p % 10;
                flag++;
                nextNum = p / 10;
                la = la.next;
                l1 = l1.next;
            } else {
                p = la.val + l1.val + nextNum;
                resTemp.next = new ListNode(p % 10);
                resTemp = resTemp.next;
                la = la.next;
                l1 = l1.next;
                nextNum = p / 10;
            }
        }
        while (l1 != null) {
            p = l1.val + nextNum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            l1 = l1.next;
            nextNum = p / 10;
        }
        while (la != null) {
            p = la.val + nextNum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            la = la.next;
            nextNum = p / 10;
        }
        if (nextNum > 0) {
            resTemp.next = new ListNode(nextNum);
        }
        return res;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode la) {

        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || la != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = la != null ? la.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (la != null) {
                la = la.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}