public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);

        System.out.println(head);

        ReverseLinkedListSolution solution = new ReverseLinkedListSolution();
        ListNode newHead = solution.reverseList(head);
        System.out.println(newHead);
        System.out.println(solution.reverseLinkedListLoop(newHead));
    }
}

class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseLinkedListLoop(ListNode head){
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev= temp;
            temp=front;
        }
        return prev;
    }
}