package Events.graphs;

import object.SuperObject;
import object.object_set;
import object.portal;
import object.portal1;
import Events.SuperEvent;
import Events.pickObjects.pickObjects;

public class graph extends SuperEvent{
    object_set objects;
    pickObjects pick;
    private int index  = 0 ;
    public int path = 0;
    private data d = new data(this);
    public void setup(){
        this.objects = gp.objects;
        objects.add(new portal1(),125,1);
                objects.add(new portal1(),125,3);
                objects.add(new portal1(),125,5); 
                                objects.add(new portal1(),125,7);
                                                                objects.add(new portal1(),125,9);
                                                                objects.add(new portal1(),120,20);
                                                                objects.add(new portal1(),120,31);
                                                                                                                                objects.add(new portal1(),113,46);

                                                                                                                                objects.add(new portal1(),101,75);



                                                                                                                                objects.add(new portal1(),114,60);




        // objects.add(new portal(),"a75",101,75);
    }
    public void draw(int path){
    //   if(d!=null)
        switch (path) {
            case 0:
                if(d.getNext("l3")){
                    objects.add(new portal1(),101,53);
                }
               
                // else if(d.getCur("l1")){
                //      System.out.println("l1");
                // }
                break;
        
            default:
                break;
        }
    }

  
    public void set(String objectName, int index,pickObjects object) {
        this.index = index;
        boolean temp = false;

        if(objectName == "portal1"){
                  d.teleport(path);
                  object.clear();
            }
   
            // d.teleport(index);
        
    
}
        // if(object.check("a75")){
        //     System.out.println(2);
            // annockunce("ab");
            // object.setTeleport(1,3);
        //     object.clear();
        // }
    }

  

