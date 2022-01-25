public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }

    }
    public void display()
    {
        ListNode current = head;
        int count=0;
        while(current != null)
        {
            System.out.print(current.data +"-->");
            count++;
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value)
    {
        ListNode newNode = new ListNode(value);
        if(head == null)
        {
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null != current.next)
        {
            current = current.next;
        }
        current.next = newNode;
    }
    public void InsertAtGivenPosition(int value,int position)
    {
        ListNode node = new ListNode(value);
        if(position==1)
        {
            node.next = head;
            head = node;
        }
        else
        {
            ListNode previous = head;
            int count = 1;
            while(count<position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;
        }
    }
    public ListNode deleteFirst()
    {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public int length()
    {
        if(head == null){
            return 0;
        }
        int count=0;
        ListNode current = head;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.display();
        System.out.println("Length is - "+sll.length());

        sll.insertFirst(115);
        sll.display();

        sll.insertLast(88);
        sll.display();

        sll.InsertAtGivenPosition(66,3);
        sll.display();

        sll.deleteFirst();
        sll.display();
    }
}
