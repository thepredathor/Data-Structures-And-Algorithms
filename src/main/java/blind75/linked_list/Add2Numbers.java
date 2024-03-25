
package blind75.linked_list;

import static blind75.linked_list.data_structure.ListNode.printLinkedList;
import blind75.linked_list.data_structure.ListNode;

public class Add2Numbers {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    //You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    //
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    //

    //Example 1:
    //
    //Input: l1 = [2,4,3], l2 = [5,6,4]
    //Output: [7,0,8]
    //Explanation: 342 + 465 = 807.
    //Example 2:
    //
    //Input: l1 = [0], l2 = [0]
    //Output: [0]
    //Example 3:
    //
    //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //Output: [8,9,9,9,0,0,0,1]
    //
    //
    //Constraints:
    //
    //The number of nodes in each linked list is in the range [1, 100].
    //0 <= Node.val <= 9
    //It is guaranteed that the list represents a number that does not have leading zeros.

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode l3 = new ListNode(0, null);
        ListNode l4 = new ListNode(0, null);
        ListNode l5 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode l6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));

        ListNode result1 = addTwoNumbersCorrect(l1, l2);
        printLinkedList(result1);
        ListNode result2 = addTwoNumbersCorrect(l3, l4);
        printLinkedList(result2);
        ListNode result3 = addTwoNumbersCorrect(l5, l6);
        printLinkedList(result3);
    }

    public static ListNode addTwoNumbersCorrect(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode currentNode = new ListNode();
        ListNode previousNode = new ListNode();
        int carry = 0;
        while ((l1 != null) || (l2 != null)) {
            int l1Val = 0;
            int l2Val = 0;
            int sum = 0;
            if (l1 != null) {
                l1Val = l1.val;
                if (l1.next != null) {
                    l1 = l1.next;
                } else {
                    l1 = null;
                }
            }
            if (l2 != null) {
                l2Val = l2.val;
                if (l2.next != null) {
                    l2 = l2.next;
                } else {
                    l2 = null;
                }
            }

            if (carry != 0) {
                sum = l1Val + l2Val + carry;
            } else {
                sum = l1Val + l2Val;
            }

            carry = sum / 10;
            sum = sum % 10;
            currentNode.val = sum;
            if (head == null) {
                head = new ListNode();
                head.val = currentNode.val;
                head.next = currentNode;
                previousNode = head;
            } else {
                currentNode.next = new ListNode();
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        if (carry != 0) {
            currentNode.val = carry;
            currentNode.next = null;
        } else {
            previousNode.next = null;
        }

        return head;
    }
}