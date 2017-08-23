package Test;

/**
 * Created by Nicole on 2017/8/23.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicateListNode {
    public static void main(String[] args){
        int[] array = {1,1, 2, 3, 3, 4, 4, 5};
        ListNode[] list = new ListNode[array.length];
        for(int i=0; i<array.length; i++){
            list[i] = new ListNode(array[i]);
        }
        for(int j=1; j<array.length; j++){
            list[j-1].next = list[j];
        }
        ListNode res = deleteDuplication(list[0]);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode deleteDuplication(ListNode root){
        if(root == null)
            return null;
        ListNode head = new ListNode(-1);
        head.next = root;
        ListNode p = head;
        ListNode q = p.next;
        while(q != null){
            while(q.next != null && q.val == q.next.val)
                q = q.next;
            if(p.next != q){
                q = q.next;
                p.next = q;
            }else{
                p = q;
                q = q.next;
            }
        }
        return head.next;
    }
}
