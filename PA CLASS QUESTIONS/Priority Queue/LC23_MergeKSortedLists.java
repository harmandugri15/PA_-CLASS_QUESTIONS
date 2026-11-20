import java.util.*;


class LC23_MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode a=lists[i];
            while(a!=null){
                pq.add(a.val);
                a=a.next;
            }
        }
        if(pq.isEmpty()){
            return null;
        }
        ListNode head=new ListNode(pq.peek());
        pq.poll();
        ListNode tail=head;
        while(!pq.isEmpty()){
            ListNode temp=new ListNode(pq.peek());
            tail.next=temp;
            tail=temp;
            pq.poll();
        }
        return head;

    
    }
}