public class addFirst {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

//ADD FIRST    
    public void Addfirst(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        //step2 = NewNode next = head
        newNode.next = head;

        //step 3 = head = newNode
        head = newNode;
    }
    public void AddLast1(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        Node currNode = head;

        while(currNode.next != null){
            currNode = currNode.next;
        }
    }

//ADD LAST
    public void AddLast(int data){
        //step 1: create newNode
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        size++;

        //step 2: tail next = newNode
        tail.next = newNode;

        //step 3: tail = newNode
        tail = newNode;
    }

    public void print(){
        if(head == null){
            System.out.println("Linkedlist is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

//ADD MID
    public void Add(int idx, int data){
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        size++;
        
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1 ; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

//REMOVE FIRST
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null ;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
        
    }

//REMOVE LAST
    // public int removeLast(){
    //     if(size == 0){
    //         System.out.println("LL is empty");

    //     }
    //     else if(size == 1){
    //         int val = head.data;
    //         head = tail = null;
    //         size = 0;
    //         return val; 
    //     }
    //     int val = prev.next ;

    //     return 0;
    // }

//ITERATIVE SEARCH
    public boolean itrSearch(int key){
        Node temp = head;
        while(temp!=null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public boolean recursiveSearch(Node Haider,int key){
        if(Haider == null){
            return false;
        }
        if(Haider.data == key){
            return true;
        }
        return recursiveSearch(Haider.next , key);
    }
    public void Reverse(){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }
    public void RemoveNthfromlast(int n){
        Node it1 = head;
        Node it2 = head;
        while(n>0){
            it2 = it2.next;
            n--;
        }
        //System.out.println(it2.data);
        while(it2.next != null){
            it1 = it1.next;
            it2 = it2.next;
        }
        it1.next = it1.next.next;
    }
    public Node findMiddle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        //step 1 -find middle
        Node mid = findMiddle();
        //step 2 - reverse middle
        Node prev = null;
        Node curr = findMiddle();
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        Node right = prev;
        Node left = head;
        //step 3 - check 1st half == 2nd half
        while(right != null){
            if(left.data != right.data){
               return false; 
            }
            right = right.next;
            left = left.next;
        }
        return true;
        
    }
    public void cycle(){
        Node it1 = head;
        while(it1.next != null){
            it1 = it1.next;
        }
        it1.next = head;
    }
    
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
          return;  
        }

        //finding meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        
        //remove cycle last.next = null
        prev.next = null;
    }
    
    public static void main(String[] args) {
           addFirst ll = new addFirst();
        // ll.print();
        // ll.Addfirst(2);
        // ll.print();
        // ll.Addfirst(1);
        // ll.print();
        // ll.AddLast(3);
        // ll.print();
        // ll.AddLast(4);
        // ll.Add(2,9);
        // ll.print();

        //ll.removeFirst();
        // ll.print();
        // boolean ans = ll.itrSearch(5);
        // System.out.println("ans :" + ans);
        
        // boolean answ = ll.recursiveSearch(ll.head , 4);
        // System.out.println("answ: " +answ);
        
        // ll.Reverse();
        // ll.print();
        
        // ll.RemoveNthfromlast(3);
        // ll.print();
        
        // boolean check = ll.checkPalindrome();
        // System.out.println("Palindrome is : "+ check);
        
        // ll.cycle();
        //ll.print();
        
        head = new Node (1);
        Node temp = new Node (2);
        head.next = temp;
        head.next.next = new Node (3);
        head.next.next.next = temp;
        //ll.print();
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());
        
        boolean check2 = ll.isCycle();
        System.out.println("Cycle exist true or false : " + check2);
        
        ll.removeCycle();
        // ll.print();
        boolean check3 = ll.isCycle();
        System.out.println("Cycle exist true or false : " + check3);
    }
}
