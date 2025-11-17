import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(40);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        FlattenLinkedListSolution solution = new FlattenLinkedListSolution();

        ListNode result = solution.flattenLinkedList(head);
        System.out.println();
        printLinkedList(result);

        result = solution.flattenLinkedListUsingArray(head);
        System.out.println();
        printLinkedList(result);
    }

    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.value);

            /* If child exists, recursively
             print it with indentation */
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.child;
        }
        System.out.println();
    }
}

class FlattenLinkedListSolution {

    /// using merge sort
    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mergedNode = flattenLinkedList(head.next);

        head = merge(head, mergedNode);
        return head;
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){
            if(list1.value < list2.value){
                temp.child = list1;
                temp = list1;
                list1 = list1.child;
            }else{
                temp.child = list2;
                temp = list2;
                list2 = list2.child;
            }
            temp.next = null;
        }

        if(list1 != null){
            temp.child= list1;
        }

        if(list2 !=null){
            temp.child = list2;
        }

        if(dummy.child != null){
            dummy.child.next = null;
        }

        return dummy.child;
    }

    /// extra usage of array
    public ListNode flattenLinkedListUsingArray(ListNode head) {
        List<Integer> arrLL = new ArrayList<>();

        while(head != null){
            ListNode temp = head;

            while(temp != null){
                arrLL.add(temp.value);
                temp = temp.child;
            }
            head = head.next;
        }

        Collections.sort(arrLL);

        ListNode dummyNode = new ListNode(-1);

        ListNode t1 = dummyNode;

        for(int i : arrLL){
            t1.child = new ListNode(i);
            t1 = t1.child;
        }

        return dummyNode.child;
    }
}
