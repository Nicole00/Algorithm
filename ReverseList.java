import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nicole on 2017/6/30.
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseList f = new ReverseList();
        ListNode newHead = f.ReverseList1(node1);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public ListNode ReverseList(ListNode head){
        if(head == null)
            return null;
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        if(q == null)
            return head;
        while(q != null){
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    public ListNode ReverseList1(ListNode head){
        if(head == null)
            return null;
        ListNode p = head;
        ListNode q = head.next;
        if(q == null){
            return head;
        }
        while(q != null){
            ListNode r = q.next;
            q.next = p;
            head.next = r;
            p = q;
            q = r;
        }
        return p;
    }
}
