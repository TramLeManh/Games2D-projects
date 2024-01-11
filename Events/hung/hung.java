package Events.hung;

import object.SuperObject;
import object.object_set;
import object.oldman;
import object.portal;

import java.awt.List;
import java.util.ArrayList;

import Events.SuperEvent;
import Events.pickObjects.pickObjects;
import KeyBoard.keyControl;
import ScoreBoard.view;


public class hung extends SuperEvent{
    object_set objects;
    pickObjects pick;
    private int index;
    int attemp = 0;
      GraphTeleport g ;
    public boolean press = true;
    private String announce;
    public view v;
    int i = 0;
    private  MapApp mapApp;
    private String[] inst = new String[10];

    public void setup(){
        this.objects = gp.objects;//do not modify this
       graph();
        objects.add(new portal(),"A1",164,22);// create portal at 101 75
        objects.add(new portal(),"A2",168,22);// create portal at 101 75
           objects.add(new oldman(),"guide",168,20);// create portal at 101 75

    }
    public void set(){
        inst[0] = "You are at A. You have 2 attempt \nFind the way to get destination E with lowest coin";
        inst[1] = "Press M to view the map. \nPress R to reset with a new map\nYou are at location A";
    }
    public void graph(){
         mapApp = new MapApp(); // create a MapApp object
                mapApp.CreateMap(); // call the CreateMap() method
                g = mapApp.getGraph(); // get the graph object
    }
    public void randon(int index){
        
    }

     
    public void set(String objectName, int index,pickObjects object) {
      
        if(object.check("A1")){
            ask(0);
        }
        else if(object.check("A2")){
           ask(1);

      
        }
        else if(object.check("guide")){
            set();
           
         announce(inst[i]);
         i+=1;
         if(i ==2 ){
            i = 1;
         }

      
        }
        
    }
    public void teleport(){
        teleport(g.getDestinationX(),g.getDestinationY());
        gp.player.setCoin(g.getMana());
    }
    //ask for teleport in quizzState.java 
    public String annouces(){
        return announce;
    }
    public void ask(String name){
        g.getEdges(name);
        announce = "Do you want to teleport " +g.getName() + " with " +g.getMana()+ " coins ? ";
        gp.setGamestate(gp.quizzState);
    }
    public void ask(int index){
        g.getEdges(index);
        announce = "Do you want to teleport " +g.getName() + " with " +g.getMana()+ " coins ? ";
        gp.setGamestate(gp.quizzState);
    }
    public void keyBoard(){
        if(keyControl.mPress==true &&press == true){
            System.err.println(2);
            press = false;
        }
       if(keyControl.mPress==true&&press==false){
                    System.err.println(3);

        press = true;
    }
       
    }
    public void openMap(){
        v = gp.v;
        getData();
        gp.openMap();
    }
    public void getData(){
        for(int i = 0; i <g.edges.size();i++){
            v.text.append((i+1)+". "+g.edges.get(i).getSource().getId()+" to " + g.edges.get(i).getDestination().getId() +". Coin: "+ g.edges.get(i).getMana() + "\n");
        }
    }
    public void reset(){
        attemp +=1;
        if(attemp == 2){
        announce("You have reset the map");
            mapApp = null;
            graph();


       
        }
        else if(attemp == 1){
            announce("You have one try");
    }
 teleport(15,14);//back to begin} 
  
}
}
