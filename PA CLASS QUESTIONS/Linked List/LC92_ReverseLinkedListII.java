
class LC92_ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right || left>right){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=0;i<left-1;i++){
            prev=prev.next;
        }
        ListNode tail=prev.next;
        ListNode curr=tail.next;
        for(int i=0;i<right-left;i++){
            tail.next=curr.next;
            curr.next=prev.next;
            prev.next=curr;
            curr=tail.next;
        }
        return dummy.next;
    }
}