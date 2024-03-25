package blind75.linked_list;

import blind75.linked_list.data_structure.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println(hasCycle(listNode1));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode mare = head;
        ListNode hare = head;

        while(mare != null && hare != null && hare.next != null) {
            mare = mare.next;
            hare = hare.next.next;

            if(mare == hare) {
                return true;
            }
        }

        return false;
    }
}
