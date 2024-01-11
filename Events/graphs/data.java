package Events.graphs;
public class data {
    String temp = "You have pass ";
    LinkList list;
    Node n;
    public Node l0,l1,l2,l3,l4,l5;
   static LinkList[] pos = new LinkList[5];
    graph g;
    public data(graph g) {
      this.g = g;
      function(0);
    }
    public void set(){
   l1 = new Node(new Location(101,19,"1"));
   l2 = new Node(new Location(102,31,"2"));
   l3  = new Node(new Location(102,46,"3"));
    l4  = new Node(new Location(102,60,"4"));
    l5  = new Node(new Location(102,73,"5"));//destination
   }
     

   public void teleport(LinkList list){
    this.list = list;
     n  = list.getNext();
            g.draw(g.path);
    Location l = n.getData();
    System.out.println("Location: "+ l.getName());
    g.teleport(l.getX(),l.getY());
    if(l.getName().equals("0")){
      g.path+=1;
      function(g.path);

      System.out.println("Path:"+g.path);
   
    }


    
    
   }
   public void teleport(int index){

    teleport(pos[index]);
   }
   public void function(int index){
        set(); 
        if(index != 0){
        pos[index-1] = null;} 
        switch (index) {
          case 0:
        pos[0] = new LinkList();
        pos[0].insert(l1);
        pos[0].insert(l3);
        pos[0].insert(l4);


            
            break;
            case 1:
        pos[1] = new LinkList();
        pos[1].insert(l2);
        pos[1].insert(l3);
        pos[1].insert(l1);
        pos[1].insert(l4);
        break;
        case 2:
        
        pos[2] = new LinkList();
        pos[2].insert(l3);
        pos[2].insert(l1);
        pos[2].insert(l2);
        pos[2].insert(l5);

        break;    
        case 3:
        pos[3] = new LinkList();
          default:
        
            break;
        }
        



       
        // pos[4] = new LinkList();


    

   }
   public boolean getNext(String l){
   if(l == "l3"){
    return check(l3);
   }
   else if(l == "l1"){
    return check(l1);
   }
   else if(l == "l2"){
    return check(l2);
   }
   else if(l == "l4"){
    return check(l4);
   }
   else if(l == "l5"){
    return check(l5);
   }
   return false;
   }
 
 

   public boolean check(Node node){
    if( this.n.next== node){

        return true;
    }
    return false;
  
   }
   public boolean checkCur(Node node){
    if( this.n== node){ 
        return true;
    }
    return false;
  
   }
}
