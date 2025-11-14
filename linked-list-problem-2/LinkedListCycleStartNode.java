import java.util.HashSet;
import java.util.List;

public class LinkedListCycleStartNode {
    public static void main(String[] args) {
        LinkedListCycleStartNodeSolution solution = new LinkedListCycleStartNodeSolution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        ListNode head = node1;

        ListNode result = solution.findStartingPoint(head);
        ListNode result2 = solution.findStartingPointHash(head);
        if(result != null){
            System.out.println(result.value);
            System.out.println(result2.value);
        }else{
            System.out.println("No cycle present");
        }
    }
}

class LinkedListCycleStartNodeSolution {

    /// O(1) space complexity O(N) time complexity
    public ListNode findStartingPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    /// O(N) space and time complexity
    public ListNode findStartingPointHash(ListNode head) {
        HashSet<ListNode> hash = new HashSet<>();

        ListNode temp = head;

        while(temp !=null){
            if(hash.contains(temp)){
                return temp;
            }
            hash.add(temp);
            temp = temp.next;
        }

        return null;
    }
}