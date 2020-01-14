package mapreduce;

import java.math.BigDecimal;

/**
 * @author wayilau
 * @Date 2020-01-14
 */
public class TwoAdd {

    public static void main(String[] args) {
        //init
        TwoAdd ta = new TwoAdd();
        ListNode l1 = ta.parse(342l);
        ListNode l2 = ta.parse(465l);
        ListNode l3 = ta.addTwoNumbers(l1, l2);
        System.out.println(ta.getListNode(l3, 1));
        System.out.println(9999999991l + 9l);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal result = getListNode(l1, 1).add(getListNode(l2, 1));
        return parse(result);
    }

    public BigDecimal getListNode(ListNode l, int p) {
        if (l.next != null) {
            return new BigDecimal(l.val * p).add(getListNode(l.next, p * 10));
        }

        return new BigDecimal(l.val * p);
    }

    public ListNode parse(BigDecimal target) {
        if (target.toBigInteger().intValue() < 10) {
            return new ListNode(target.toBigInteger().intValue());
        } else {
            ListNode l = new ListNode(target % 10);
            l.next = parse(target / 10);
            return l;
        }
    }

}

class ListNode {
    long val;
    ListNode next;

    ListNode(long x) {
        val = x;
    }
}
