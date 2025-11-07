public class ListNode {
    ListNode next;
    int value;

    public ListNode(int value){
        this.next = null;
        this.value = value;
    }

    public ListNode(ListNode next, int value){
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value+" -> "+this.next;
    }

}
