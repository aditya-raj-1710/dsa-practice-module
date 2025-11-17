public class RotateLinkedList {
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

        System.out.println(head);

        RotateLinkedListSolution solution = new RotateLinkedListSolution();
        int rotate = 3;

        head = solution.rotateRight(head, rotate);
        System.out.println(head);
        head = solution.rotateRightInitial(head,rotate);
        System.out.println(head);

    }
}

class RotateLinkedListSolution {

    /// Optimal Solution
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode temp = head;
        int size = 1;
        while( temp.next != null){
            size++;
            temp = temp.next;
        }
        temp.next = head;
        k = k%size;

        int end = size -k;

        while(end-- > 0){
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    /// Personal solution -- 2 pointer usage
    ///
    /// 1st pointer points to end then attach to head to form the loop
    /// 2nd pointer points to the new end and make the next variable for the node as null to end the loop
    public ListNode rotateRightInitial(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode t1 = head;
        int size = 0;
        while( t1 != null){
            size++;
            t1 = t1.next;
        }

        k = k%size;
        if(k ==0){
            return head;
        }

        ListNode curr = head;
        ListNode end = head;

        for(int i=0;i<k;i++){ //move 1st pointer K places
            end = end.next;
        }

        while(end.next != null){
            curr = curr.next;
            end = end.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        end.next = head;
        head = newHead;

        return head;
    }
}