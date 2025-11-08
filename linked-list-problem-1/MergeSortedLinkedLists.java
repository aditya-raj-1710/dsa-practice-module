public class MergeSortedLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("First sorted linked list: "+list1);
        System.out.println("Second sorted linked list: "+list2);
        MergeSortedLinkedListsSolution solution = new MergeSortedLinkedListsSolution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        System.out.println("Merged sorted linked list: "+mergedList);
    }
}

class MergeSortedLinkedListsSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(list1 !=null && list2!= null){
            if(list1.value <list2.value){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }

        return head.next;
    }
}