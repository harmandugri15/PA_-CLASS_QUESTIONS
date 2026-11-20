// LeetCode 147: Insertion Sort List
public class LC147_InsertionSortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            // Find insertion position
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sorted = insertionSortList(head);
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
        System.out.println();
    }
}
