public class ReverseGroupLinkedList {
    public static void main(String[] args) {
        ReverseGroupLinkedListSolution solution = new ReverseGroupLinkedListSolution();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(head);
        head = solution.reverseKGroup(head,3);
        System.out.println(head);
    }
}

class ReverseGroupLinkedListSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp !=null){
            ListNode kThNode = getKthNode(temp,k);

            if(kThNode == null){ /// no actual group exist in the end
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }

            //track access to rest of remaining list
            ListNode nextNode = kThNode.next;

            //required for reverseLL to work
            kThNode.next = null;

            reverseLinkedList(temp);

            if( temp == head){ //beginning group of K nodes
                head = kThNode;
            }else{
                prevNode.next = kThNode;
            }

            prevNode = temp;

            temp = nextNode;
        }

        return head;
    }

    /// Return the Kth element
    ListNode getKthNode(ListNode temp, int k){
        k -=1; // temp itself is the first element

        while(temp !=null & k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    /// Normal reverse LL logic; Kth node here points to null so doesn't need end LL address
    void reverseLinkedList(ListNode tempHead){
        ListNode temp = tempHead;

        ListNode prev = null;

        while(temp != null){

            ListNode nextNode = temp.next;

            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
    }
}