
class CircularLinkedList_Class_Operations {

    Node head;
    int size = 0;

    public static class Node {

        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addatlast(int data) {
        size++;
        Node a = new Node(data);
        if (head == null) {
            head = a;
            head.next = head;
            return;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = a;
            a.next = head;
        }
    }

    public void addatfirst(int data) {
        size++;
        Node a = new Node(data);
        if (head == null) {
            head = a;
            head.next = head;
            return;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = a;
            a.next = head;
            head = a;
        }
    }

    public int size() {
        return size;
    }

    public void printforeward() {
        if (head == null) {
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    public boolean checkcycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node findmiddle() {
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node createlist(int n) {
        Node head = null;
        Node tail = null;
        for (int i = 1; i <= n; i++) {
            Node newnNode = new Node(i);
            if (head == null) {
                head = newnNode;
                tail = newnNode;
            } else {
                tail.next = newnNode;
                tail = newnNode;
            }
        }
        tail.next = head;
        return head;
    }

    public Node joseph(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }
        
        // Generate the game list and assign it as the active class head
        this.head = createlist(n);
        
        Node prev = this.head;
        while (prev.next != this.head) {
            prev = prev.next;
        }

        // Eliminate every k-th node until only one remains
        while (this.head != prev) {
            for (int i = 1; i < k; i++) {
                prev = this.head;
                this.head = this.head.next;
            }
            // Kill the k-th node
            prev.next = this.head.next;
            this.head = prev.next;
        }
        return this.head;
    }


    public static void main(String[] args) {
        CircularLinkedList_Class_Operations cll = new CircularLinkedList_Class_Operations();
        cll.addatlast(1);
        cll.addatlast(2);
        cll.addatlast(3);
        cll.addatlast(4);

        cll.printforeward();

        cll.addatfirst(500);
        System.out.println(" ");
        cll.printforeward();
        System.out.println(" ");

        int aa = cll.size();
        System.out.print("Size is : " + aa);

        System.out.println(cll.checkcycle());
        Node a = cll.findmiddle();
        System.out.print("Middle is :" + a.data);
        System.out.println();

        cll.createlist(cll.size());
        cll.joseph(cll.size(), 2);
        cll.printforeward();

    }

}
