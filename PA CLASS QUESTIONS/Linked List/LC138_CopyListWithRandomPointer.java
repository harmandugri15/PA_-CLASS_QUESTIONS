// LeetCode 138: Copy List With Random Pointer
public class LC138_CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // O(n) Time, O(1) Auxiliary Space (Interweaving original & cloned nodes)
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and insert them next to original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers to clone nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        n1.next = n2;
        n2.next = n3;
        n2.random = n1;
        n3.random = n2;

        Node copied = copyRandomList(n1);
        System.out.println("Copied head value: " + (copied != null ? copied.val : "null"));
    }
}
