package blind75.linked_list.data_structure;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printLinkedList(ListNode head) {
        System.out.print(head.val + " -> ");
        while (head.next != null) {
            System.out.print(head.next.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}


