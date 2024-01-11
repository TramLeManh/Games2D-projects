package Events.hung;

import object.SuperObject;
import object.object_door;
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
    int attemp = 1;
      GraphTeleport g ;
    public boolean press = true;
    private String announce;
    public view v;
    int i = -1;
    private  MapApp mapApp;
    private String[] inst = new String[10];

    public void setup(){
        this.objects = gp.objects;//do not modify this
       graph();
        objects.add(new portal(),"A123",164,22);// create portal at 101 75
        objects.add(new portal(),"A223",168,22);// create portal at 101 75
        objects.add(new portal(),"A323",166,18);// create portal at 101 75
                objects.add(new portal(),"B1",205,22);// create portal at 101 75
                   objects.add(new portal(),"B2",203,20);// create portal at 101 75
                    objects.add(new portal(),"B3",207,20);
                            objects.add(new portal(),"C1",190,56);
                                    objects.add(new portal(),"C2",180,52);
                                    objects.add(new portal(),"C3",187,55);
                                    objects.add(new portal(),"D1",180,42);
                                    objects.add(new portal(),"D2",184,42);
                                    objects.add(new portal(),"D3",184,39);
                                           objects.add(new portal(),"E1",224,41);
                                           objects.add(new portal(),"E2",224,38);
                                                objects.add(new portal(),"E3",220,41);

           objects.add(new oldman(),"guide",168,20);// create portal at 101 75
                  objects.add(new object_door(),"Exit",165,18);// create portal at 101 75

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
      
        if(index== object.hashFunc("A123")){
            System.out.println("A123");
            ask(0);
        }
         if(index== object.hashFunc("A223")){
            System.out.println("A223");
           ask(1);
      
        }
               if(index== object.hashFunc("A323")){
                 System.out.println("A323");
           ask(2);
      
        }
         if(object.check("B1")){
           ask(3);
      
        }
          if(object.check("B2")){
           ask(4);
      
        }
          if(object.check("B3")){
           ask(5);
      
        }
         if(object.check("C1")){
           ask(6);
      
        }
             if(object.check("C2")){
           ask(7);
      
        }
           if(object.check("C3")){
           ask(8);
      
        }
           if(object.check("D1")){
           ask(9);
      
        }
         if(object.check("D2")){
           ask(10);
      
        }
           if(object.check("D3")){
           ask(11);
      
        }
        if(object.check("E1")){
           ask(12);
      
        }
          if(object.check("E2")){
           ask(13);
      
        }
          if(object.check("E3")){
           ask(14);
      
        }
        //  else if(object.check("guide")){
        //     set();
        //    i+=1;
        //  announce(inst[i]);
         
        //  if(i ==1 ){
        //     i = 0;
        //  }

      
        // }
    //      if(object.check("Exit")&&objectName == "door"){
    //         System.out.println(2);
    //        if(gp.player.coin == mapApp.getshortWeight()){
    //         System.out.println("Success!");
    //        }
    //        else{
    //          if(attemp == 2){
    //         announce("Wrong. Press R to reset");
         
    //     }
    //     else if(attemp == 1){
    //         announce("You have one try. Press R to reset");
    // }
    //        }

      
    //     }
        
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
        System.out.println(g.getName() );
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
