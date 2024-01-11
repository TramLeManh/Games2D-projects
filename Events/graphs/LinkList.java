package Events.graphs;

public class LinkList {
    private   static Node head = null;//every location has one destination
    private   Node cur = null;
    private Node tail = null;

    StringBuilder pos = new StringBuilder();
    public LinkList() {
        this.head  = new Node(new Location(106,3,"0"));
    this.cur = head;

        cur.next = head;
        tail = head;
    }
    
    
    public void insert(Node newNode) {

            if(head.next == null){
                head.next = newNode;
                tail = newNode;
                newNode.next = head;
            }
            else{
                tail.next = newNode;
                tail = newNode;
                newNode.next = head;
            }
        
    }
    public Node getNext() {
        this.cur = this.cur.next;
        return this.cur;
    }
    public void addLast(String l){
        if(cur == head) {
            // pos.append(l+"");
            // // pos.reverse();
             System.out.println("You have pass " + pos.toString());
        }
        else if(cur.next == head){
            pos.append(l+"");
        }

        else{
            pos.append(l+",");
        };
            
          
        
    }
    public Node getCur() {
        return cur;
    }
    public void nextPath(graph g){
        if(this.cur == this.head) {
            g.path +=1;
            System.out.println("Path: "+g.path);
        }else{
            //  System.out.println(123);
        }
    }
    public boolean checkNext(Node n){
        if(this.cur.next== n){
            return true;
        }
        return false;
    }
    
    

}
