import java.util.HashMap;

public class CloneLinkedList {
    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        ListNode head = new ListNode(7);
        head.next = new ListNode(14);
        head.next.next = new ListNode(21);
        head.next.next.next = new ListNode(28);

        // Assigning random pointers
        head.random = head.next.next; // 7 -> 21
        head.next.random = head; // 14 -> 7
        head.next.next.random = head.next.next.next; // 21 -> 28
        head.next.next.next.random = head.next; // 28 -> 14

        System.out.println(head);
        CloneLinkedListSolution solution = new CloneLinkedListSolution();
        System.out.println(solution.copyRandomList(head));
    }
}

class CloneLinkedListSolution {

    /// O(n) solution with O(1) space
    public ListNode copyRandomList(ListNode head) {
        if(head == null){
            return null;
        }

        insertCopyInBetween(head);

        connectRandomPointers(head);

        return getDeepCopyList(head);
    }

    private void insertCopyInBetween(ListNode head){
        ListNode temp = head;

        while(temp != null){
            ListNode copy = new ListNode(temp.value);

            ListNode nextNode = temp.next;

            copy.next = nextNode;
            temp.next = copy;
            temp = nextNode;
        }
    }

    private void connectRandomPointers(ListNode head){
        ListNode temp = head;

        while(temp != null){
            ListNode copy = temp.next;
            if(temp.random != null){
                copy.random = temp.random.next;
            }else{
                copy.random = null;
            }

            temp = temp.next.next;
        }
    }

    private ListNode getDeepCopyList(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        ListNode temp = head;

        while(temp != null){
            result.next = temp.next;
            result = result.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    /// O(n) solution with O(n) space
    public ListNode copyRandomListBasic(ListNode head) {
        HashMap<ListNode,ListNode> hash = new HashMap<>();
        ListNode temp = head;

        while(temp != null){
            ListNode node = new ListNode(temp.value);
            hash.put(temp,node);
            temp = temp.next;
        }
        temp = head;

        while(temp != null){
            ListNode copyNode = hash.get(temp);
            copyNode.next = hash.get(temp.next);
            copyNode.random = hash.get(temp.random);
            temp = temp.next;
        }
        System.out.println(hash);
        return hash.get(head);
    }
}