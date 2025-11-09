public class AddLinkedListNums {
    public static void main(String[] args) {
        /// 8,6,1,7,1,8,2,1,6,2,5
        ListNode list1 = new ListNode(8);
        list1.next = new ListNode(6);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(7);
        list1.next.next.next.next = new ListNode(1);
        list1.next.next.next.next.next = new ListNode(8);
        list1.next.next.next.next.next.next = new ListNode(2);
        list1.next.next.next.next.next.next.next = new ListNode(1);
        list1.next.next.next.next.next.next.next.next = new ListNode(6);
        list1.next.next.next.next.next.next.next.next.next = new ListNode(2);
        list1.next.next.next.next.next.next.next.next.next.next = new ListNode(5);

        /// 9,0,2
        ListNode list2 = new ListNode(9);
        list2.next = new ListNode(0);
        list2.next.next = new ListNode(2);

        System.out.println("list1 :"+list1);
        System.out.println("list :"+ list2);

        AddLinkedListNumsSolution solution = new AddLinkedListNumsSolution();

        System.out.println("Addition:"+ solution.addTwoNumbers(list1,list2));
    }
}

class AddLinkedListNumsSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        long carryOver = 0;

        while((l1 !=null || l2 != null) || carryOver !=0){
            int sum =0;

            if(l1 != null){
                sum +=l1.value;
                l1 = l1.next;
            }

            if(l2 != null){
                sum +=l2.value;
                l2 = l2.next;
            }

            sum += carryOver;

            carryOver = sum /10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;

            temp = temp.next;
        }
        return dummy.next;
    }
}
