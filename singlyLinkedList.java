package linkedList;
class singlyLinkedList<T>{
    //Node Class have the capability to hold a Data and Address of a Next Node
    private class Node{   
        T data;//Node Contains Data
        Node next;//and Address of Next Node
        public Node(T data, Node next) {
            this.data = data;
            this.next = null;
        }
        public Node() {
            //To Create header Node
        }     
    }
    
    private Node head=new Node();//header of a Linked List
    private int length=0;//Holds length of list
    
    //Returns length of the list
    public int getLength(){
        if(head.next==null)return 0;
        Node cur=head.next;
        while(cur.next!=null){
            cur=cur.next;
            length++;
        }
        return length+1;
    }
    
    //Add's Node to the begining of the List
    public void addFirst(T data){
        //Creation of a Node
        Node node=new Node(data,null);
        //Insertion of First Node
        if(head.next==null){
            head.next=node;
            return;
        }
        Node cur=head.next;//Mark first node as cur
        node.next=cur;//make new node to point cur node
        head.next=node;//make head to point new node
    }
    //Add's New Node to the End of the List
    public void addLast(T data){
        //Creation of a Node
        Node node=new Node(data,null);
        //Insertion of First Node
        if(head.next==null){
            head.next=node;
            return;
        }
        //Insertion of Node In between
        Node cur = null;
        cur=head.next;
        while(cur.next!=null)
            cur=cur.next;
        cur.next=node;
    }
    //Removes the Node which contains the data
    public void remove(T data) throws underFlowException{
        if(head.next==null){
            throw new underFlowException("There is No Data to Print");      
        }
        Node cur=head.next;//Current node points to First Node
        Node pre=head;//Previous node points to head Node
        while(cur.next!=null){//Till the end of the List
            if(cur.data==data){//If data is Found
                Node del=cur;//Point the deleting node to del node
                pre.next=del.next;//Make previous node to point next node
                del=null;//Delete the node and make eligiable for garbage collection
                return;
            }
            //Iterations
            pre=cur;
            cur=cur.next;
        }
        //If the data to be deleted is in the last node
        if(cur.data==data){
                Node del=cur;
                pre.next=del.next;
                del=null;
        }
    }
    //removes the first Node of the List
    public void removeFirst() throws underFlowException{
        if(head.next==null){
            throw new underFlowException("There is No Data to Remove");      
        }
        Node cur=head.next;
        Node del=cur;
        head.next=del.next;
        del=null;//Delete the node and make eligiable for garbage collection
    }
    //removes the Last Node of the List
    public void removeLast() throws underFlowException{
        if(head.next==null){
            throw new underFlowException("There is No Data to Print");      
        }
        Node cur=head.next;
        Node pre=head;
        while(cur.next!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next=null;
        cur=null;//Delete the node and make eligiable for garbage collection
    }
    //Return's the list as an Object array
    public Object[] getList() throws underFlowException{
         if(head.next==null){
            throw new underFlowException("There is No Data to Print");      
            }
        Object list[]=new Object[getLength()];
        Node cur=head.next;
        int i;
        for(i=0;cur.next!=null;i++){
            list[i]=cur.data;
            cur=cur.next;
        }
        list[i]=cur.data;
        return list;  
    }
}
//Custom Exception to handle Exception when there is No Data to perfoem operations
class underFlowException extends Exception{
    public underFlowException(String message) {
        super(message);
    }
    @Override
    public String toString(){
        return "NO DATA TO PERFORM THE OPERATION";
    }
}
