package blind75.linked_list;

import static blind75.linked_list.data_structure.ListNode.printLinkedList;
import blind75.linked_list.data_structure.ListNode;
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        ListNode listNode6 = new ListNode(1);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(3);
        ListNode listNode9 = new ListNode(4);
        ListNode listNode10 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;

        ListNode reverseHead = reverseList(listNode1);
        ListNode reverseHead2 = reverseListRecursive(listNode6);
        printLinkedList(reverseHead);
        printLinkedList(reverseHead2);
    }



    public static ListNode reverseList(ListNode head) {
        ListNode headReverse = new ListNode(head.val, null);

        while (head.next != null) {
            ListNode currentNode = new ListNode();
            currentNode.val = head.next.val;
            currentNode.next = headReverse;

            headReverse = currentNode;
            head = head.next;
        }

        return headReverse;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;

    }
}

