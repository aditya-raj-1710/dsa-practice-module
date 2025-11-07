import java.util.List;

public class LinkedListMiddle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        LinkedListMiddleSolution solution = new LinkedListMiddleSolution();

        System.out.println(head);
        ListNode middle = solution.middleOfLinkedList(head);
        System.out.println(middle);
    }
}

class LinkedListMiddleSolution {
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
