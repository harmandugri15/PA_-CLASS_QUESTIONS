
class LinkedList2 {

    Node head;

    public class Node {

        public int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    LinkedList2() {
        this.head = null;
    }

    public boolean detectAndRemoveCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = head;

        if (slow != fast) {
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        Node curr = slow;

        while (curr.next != slow) {
            curr = curr.next;
        }
        curr.next = null;

        return true;
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void displayLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Node cycleStart = list.head.next.next;

        Node temp = list.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = cycleStart;

        boolean doesithascycyle = list.detectAndRemoveCycle();

        System.out.println("ound " + doesithascycyle);
        System.out.println("after removing the cycle");
        list.displayLL();
    }
}

// explanation 
// in this code we will be using floyd's slow fast algorithm in which slow will move one step and fast will move two steps until they meet or fast reaches null
// if fast reaches null than there is no cycle but if slow== fast than there is cycle present .
// than we will move slow from the head  and  fast  from where it was ,one step each till they meet again this will give us the position
// of start of the cycle 
// and than to remove it we will take a variable and loop from the positioj of slow ie the start of the loop until out next element is slow 
// than we can just fo curr.next=null to break the cycle .
