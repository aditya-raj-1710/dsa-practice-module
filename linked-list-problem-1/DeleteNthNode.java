import java.util.*;

public class DeleteNthNode {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;
        // Creation of linked list
        ListNode head = new ListNode(arr.get(0));
        head.next = new ListNode(arr.get(1));
        head.next.next = new ListNode(arr.get(2));
        head.next.next.next = new ListNode(arr.get(3));
        head.next.next.next.next = new ListNode(arr.get(4));

        System.out.println("Linked List: "+ head);
        DeleteNthNodeSolution sol = new DeleteNthNodeSolution();
        head = sol.removeNthFromEnd(head, N);

        System.out.println("Final Linked List:" + head);

    }
}

class DeleteNthNodeSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }


        while(fast.next !=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
