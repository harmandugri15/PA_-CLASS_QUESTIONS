
class DoublyLinkedList_Implementation {

    public Node head;
    public Node tail;

    static class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addlast(int data, Node head) {
        Node nn = new Node(data);
        if (this.head == null) {
            this.head = nn;
            tail = nn;
            return;
        }
        if (tail == null) {
            tail = nn;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;

    }

    public void addlast(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = nn;
            tail = nn;
            return;
        }

        tail.next = nn;
        nn.prev = tail;
        tail = nn;

    }

    public void addtofirst(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = nn;
            tail = nn;
            return;
        }
        nn.next = head;
        head.prev = nn;
        head = nn;
    }

    public void printforeward() {
        Node nn = head;
        while (nn != null) {
            System.out.print(nn.data + " ");
            nn = nn.next;
        }

    }

    public void printbackward() {
        Node nn = tail;
        while (nn != null) {
            System.out.print(nn.data + " ");
            nn = nn.prev;
        }

    }

    public void deletefrombegining() {
        if (head == null && tail == null) {
            return;
        }
        head = head.next;
        head.prev = null;

    }

    public void deletefromlast() {
        if (head == null && tail == null) {
            return;
        }
        tail = tail.prev;
        tail.next = null;

    }

    public void rev() {
        Node curr = head;
        Node newhead = null;
        while (curr != null) {
            //swapping
            Node temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            newhead = curr;
            curr = curr.prev;
        }
        head = newhead;
    }

    public static void main(String[] args) {
        DoublyLinkedList_Implementation l1 = new DoublyLinkedList_Implementation();

        l1.addlast(10);
        l1.addlast(20);
        l1.addlast(30);
        l1.addtofirst(100);
        System.out.println("\n---------------");

        l1.printforeward();
        System.out.println();
        l1.printbackward();
        System.out.println("\n---------------");

        l1.addlast(500);
        System.out.println();
        l1.printforeward();
        System.out.println("\n---------------");

        l1.deletefrombegining();
        l1.deletefromlast();
        System.out.println();
        l1.printforeward();

        System.out.println("---------------------------");
        l1.rev();
        System.out.println();
        l1.printforeward();

    }
}
