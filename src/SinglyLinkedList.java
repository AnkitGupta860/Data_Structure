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

    public ListNode deleteLast()
    {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next != null)
        {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    public void DeleteAtGivenPosition(int position)
    {
        if(position ==1)
        {
            head = head.next;
        }
        else
        {
            ListNode previous = head;
            int count = 1;
            while(count < position-1)
            {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public boolean SerachingKey(ListNode head,int searchKey)
    {
        if(head==null)
        {
            return false;
        }
        ListNode current = head;
        while(current != null)
        {
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode removenthfromlast(int n)
    {
        ListNode current = head;
        ListNode dummy = head;
        int count = 0;
        while(count<n)
        {
            current = current.next;
            count++;
        }
        while(current!=null)
        {
            current = current.next;
            dummy = dummy.next;
        }
        return dummy;
    }
    public void RemoveDuplicate()
    {
        ListNode current = head;
        while(current != null && current.next != null)
        {
            if(current.data == current.next.data)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }
        }
    }

    public ListNode InsertNodeInSortedLL(int value)
    {
        ListNode newNode = new ListNode(value);

        if(head == null)
        {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;

        while(current!=null && current.data < newNode.data)
        {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
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

        sll.deleteLast();
        sll.display();

        sll.DeleteAtGivenPosition(2);
        sll.display();

        if(sll.SerachingKey(sll.head, 8)){
            System.out.println("Search key found");
        }
        else
        {
            System.out.println("Search key not found");
        }

    }
}
