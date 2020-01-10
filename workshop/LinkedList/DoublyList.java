package workshop.LinkedList;


public class DoublyList {
    private class ListNode {
        private int item;
        private ListNode next;
        private ListNode previous;

        public ListNode(int item) {
            this.item = item;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;


    public void addFirst(int element) {
        ListNode newHead = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }
    }

}
