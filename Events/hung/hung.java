package Events.hung;

import object.SuperObject;
import object.object_set;
import object.portal;
import Events.SuperEvent;
import Events.pickObjects.pickObjects;

public class hung extends SuperEvent{
    object_set objects;
    pickObjects pick;
    private int index;
    public void setup(){
        this.objects = gp.objects;//do not modify this
        objects.add(new portal(),"a75",101,75);// create portal at 101 75
    }

  
    public void set(String objectName, int index,pickObjects object) {
        this.index = index;//do not change
        if(object.check("a75")){// check what to to if hit portal a75
            System.out.println(2);
            announce("ab");//announce
            object.setTeleport(1,3);//teleport after seeing announce pressing space 
            object.clear();
        }
    }

  
}
