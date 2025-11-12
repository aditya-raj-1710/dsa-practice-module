import java.util.HashSet;

public class DetectLoop {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        DetectLoopSolution solution = new DetectLoopSolution();
        System.out.println(solution.hasCycle(head));
        System.out.println(solution.hasCycleUsingHash(head));

    }
}

class DetectLoopSolution {

    /// Optimal approach - slow & fast pointer
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /// Hash approach - O(N) space usage
    public boolean hasCycleUsingHash(ListNode head) {
        HashSet<ListNode> hash = new HashSet<>();

        while(head != null){
            if(hash.contains(head)){
                return true;
            }
            hash.add(head);
            head = head.next;
        }
        return false;
    }
}