import java.util.HashSet;

public class IntersectionNode {
    public static void main(String[] args) {
        IntersectionNodeSolution solution = new IntersectionNodeSolution();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next = new ListNode(6);

        ListNode listIntersection = list1.next.next.next;

        ListNode list2 = null;
        list2 = new ListNode(1);
        list2.next = listIntersection;

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(solution.getIntersectionNodeBrute(list1,list2));

        System.out.println(solution.getIntersectionNode(list1,list2));

        System.out.println(solution.getIntersectionNodeOptimal(list1,list2));

    }
}

class IntersectionNodeSolution {

    /// Optimal approach
    public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2){
                return temp1;
            }

            if(temp1 == null){
                temp1 = headB;
            }
            if(temp2 == null){
                temp2 = headA;
            }
        }

        return temp1;
    }

    /// Better approach
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int n1 = 0, n2 = 0;

        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        if (n1 < n2) return collisionPoint(headA, headB, n2 - n1);

        return collisionPoint(headB, headA, n1 - n2);
    }

    private ListNode collisionPoint(ListNode smallerListHead, ListNode longerListHead, int len) {
        ListNode temp1 = smallerListHead;
        ListNode temp2 = longerListHead;

        while (len > 0) {
            temp2 = temp2.next;
            len--;
        }

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }

    /// Bruteforce approach
    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        HashSet<ListNode> listAHash = new HashSet<>();

        while(headA != null){
            listAHash.add(headA);
            headA = headA.next;
        }

        while(headB !=null){
            if(listAHash.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
