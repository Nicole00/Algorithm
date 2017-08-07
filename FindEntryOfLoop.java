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

public class FindEntryOfLoop {
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
        node5.next = node1;
        FindEntryOfLoop f = new FindEntryOfLoop();
        ListNode newHead = f.ReverseList1(node1);

        ListNode result = f.EntryNodeOfLoop(node1);
        System.out.println(result.val);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode p = pHead;
        Set<ListNode> set = new HashSet<ListNode>();
        int count = 0;
        while(p != null){
            set.add(p);
            count++;
            int len = set.size();
            if(len < count){
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
