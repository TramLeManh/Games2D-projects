package Events;

import object.SuperObject;
import object.object_set;
import object.portal;
import Events.pickObjects.pickObjects;

public class graph extends SuperEvent{
    object_set objects;
    pickObjects pick;
    private int index;
    public void setup(){
        this.objects = gp.objects;
        // objects.add(new portal(),"a75",101,75);
    }

  
    public void set(String objectName, int index,pickObjects object) {
        this.index = index;
        // if(object.check("a75")){
        //     System.out.println(2);
        //     announce("ab");
        //     object.setTeleport(1,3);
        //     object.clear();
        // }
    }

  
}
