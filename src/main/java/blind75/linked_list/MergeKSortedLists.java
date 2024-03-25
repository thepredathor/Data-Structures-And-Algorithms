package blind75.linked_list;

import blind75.linked_list.data_structure.ListNode;

public class MergeKSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        boolean areListsNull = true;

        for (int i = 0; i < lists.length; i++) {
            areListsNull &= lists[i] == null;
        }
        if (areListsNull) {
            return null;
        }

        ListNode head = null;
        ListNode currentNode;
        ListNode previousNode = new ListNode();

        boolean areListsNotNull = true;

        while (areListsNotNull) {
            areListsNotNull = false;
            currentNode = new ListNode();
            int currentIndex = -1;
            int smallestNumber = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < smallestNumber) {
                        smallestNumber = lists[i].val;
                        currentIndex = i;
                    }
                }

            }
            currentNode.val = smallestNumber;
            lists[currentIndex] = lists[currentIndex].next;
            if (head == null) {
                head = currentNode;
                previousNode = head;
            } else {
                previousNode.next = currentNode;
                previousNode = previousNode.next;
            }

            for (int i = 0; i < lists.length; i++) {
                areListsNotNull |= (lists[i] != null);
            }
        }

        return head;
    }
}
