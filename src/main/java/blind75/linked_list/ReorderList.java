package blind75.linked_list;

import blind75.linked_list.data_structure.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode reversedListHead = reverseList(head);

        int size = 1;
        ListNode currentNode = head;

        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }

        int currentIndex = 0;
        ListNode copyOfReverseCurrentNode = new ListNode();

        while ((head.next != null) && (reversedListHead.next != null) && (currentIndex < size)) {
            copyOfReverseCurrentNode = new ListNode(reversedListHead.val);
            copyOfReverseCurrentNode.next = head.next;

            currentIndex++;
            if (currentIndex >= size) {
                break;
            }
            head.next = copyOfReverseCurrentNode;

            head = head.next.next;
            reversedListHead = reversedListHead.next;
            ++currentIndex;
            //part of reverse copy
        }
        if ((size % 2) == 0) {
            copyOfReverseCurrentNode.next = null;
        } else {
            head.next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
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
}
