package blind75.linked_list;

import blind75.linked_list.data_structure.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode currentNode;
        ListNode previousNode = new ListNode();

        if ((list1 == null) && (list2 == null)) {
            return null;
        }

        while ((list1 != null) || (list2 != null)) {
            currentNode = new ListNode();
            if ((list1 != null) && (list2 != null)) {
                if (list1.val < list2.val) {
                    currentNode.val = list1.val;
                    list1 = list1.next;
                } else {
                    currentNode.val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                currentNode.val = list1.val;
                list1 = list1.next;
            } else {
                currentNode.val = list2.val;
                list2 = list2.next;
            }
            if (head == null) {
                head = currentNode;
                previousNode = head;
            } else {
                previousNode.next = currentNode;
                previousNode = previousNode.next;
            }
        }

        return head;
    }
}
