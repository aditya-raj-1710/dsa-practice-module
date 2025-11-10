public class DeleteLinkedListNode {
    public static void main(String[] args) {
        DeleteLinkedListNodeSolution solution = new DeleteLinkedListNodeSolution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode deleteNode = list1.next;
        System.out.println(list1);
        solution.deleteNode(deleteNode);
        System.out.println(list1);
    }
}

class DeleteLinkedListNodeSolution{
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        ListNode temp = node;
        temp = temp.next.next;
        node.next = temp;

    }
}
