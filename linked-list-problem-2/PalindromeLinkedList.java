import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedListSolution solution = new PalindromeLinkedListSolution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        System.out.println(head);

        System.out.println("Is Palindrome? "+ solution.isPalindrome(head));

        System.out.println(head);
        System.out.println("Is Palindrome? "+ solution.isPalindromeStack(head));
    }
}

class PalindromeLinkedListSolution {
    /// In place solution
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while( fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = reverseLinkedList(slow.next);
        ListNode secondHalf = newHead;
        ListNode firstHalf = head;
        while(secondHalf != null){
            if(firstHalf.value != secondHalf.value){
                reverseLinkedList(newHead);
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        reverseLinkedList(newHead);
        return true;
    }

    ListNode reverseLinkedList(ListNode temp){
        ListNode tempH = temp;
        ListNode prev = null;
        while(tempH != null){
            ListNode nextN = temp.next;
            tempH.next = prev;
            prev = tempH;
            tempH= nextN;

        }
        return prev;
    }

    /// O(n) space usage due to stack
    public boolean isPalindromeStack(ListNode head){
        ListNode temp = head;

        Stack<Integer> nodeStack = new Stack<>();

        while(temp != null){
            nodeStack.push(temp.value);
            temp = temp.next;
        }

        while(head != null){
            if(head.value != nodeStack.pop()){
                return false;
            }
            head = head.next;
        }

        return true;
    }

}
