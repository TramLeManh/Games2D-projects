package Events.hung;

import Events.SuperEvent;
import Events.pickObjects.pickObjects;
import KeyBoard.keyControl;
import ScoreBoard.view;
import java.awt.List;
import java.util.ArrayList;
import object.SuperObject;
import object.object_door;
import object.object_set;
import object.oldman;
import object.portal;
import object.portal1;

public class hung extends SuperEvent {

  object_set objects;
  pickObjects pick;
  private int index;
  int attemp = 1;
  GraphTeleport g;
  public boolean press = true;
  private String announce;
  public view v;
  int i = -1;
  private MapApp mapApp;
  private String[] inst = new String[10];

  public void setup() {
    this.objects = gp.objects; //do not modify this
    graph();
    objects.add(new portal(), "A123", 164, 22); // create portal at 101 75
    objects.add(new portal(), "A223", 168, 22); // create portal at 101 75
    objects.add(new portal(), "A323", 166, 18); // create portal at 101 75
    objects.add(new portal(), "B1412", 205, 22); // create portal at 101 75
    objects.add(new portal(), "B2345", 203, 20); // create portal at 101 75
    objects.add(new portal(), "B3456", 207, 20);
    objects.add(new portal(), "C1412", 190, 56);
    objects.add(new portal(), "C2412", 190, 52);
    objects.add(new portal(), "C3457", 187, 55);
    objects.add(new portal(), "D1789", 180, 42);
    objects.add(new portal(), "D2456", 184, 42);
    objects.add(new portal(), "D3896", 184, 39);
    objects.add(new portal(), "E178*", 224, 41);
    objects.add(new portal(), "E245#", 224, 38);
    objects.add(new portal(), "E3141", 220, 41);

    objects.add(new oldman(), "guide", 168, 20); // create portal at 101 75
    objects.add(new object_door(), "Exit", 151, 40); // create portal at 101 75
  }

  public void set() {
    inst[0] =
      "You are at A. You have 2 attempt \nFind the way to get destination E with lowest coin";
    inst[1] =
      "Press M to view the map. \nPress R to reset with a new map\nYou are at location A";
  }

  public void graph() {
    mapApp = new MapApp(); // create a MapApp object
    mapApp.CreateMap(); // call the CreateMap() method
    g = mapApp.getGraph(); // get the graph object
  }

  public void randon(int index) {}

  public void set(String objectName, int index, pickObjects object) {
    if (index == object.hashFunc("A123")) {
      System.out.println("A123");
      ask(0);
    }
    if (index == object.hashFunc("A223")) {
      System.out.println("A223");
      ask(1);
    }
    if (index == object.hashFunc("A323")) {
      System.out.println("A323");
      ask(2);
    }
    if (index == object.hashFunc("B1412")) {
      System.out.println("B1412");

      ask(3);
    }
    if (index == object.hashFunc("B2345")) {
      System.out.println("B2345");

      ask(4);
    }
    if (index == object.hashFunc("B3456")) {
      System.out.println("B3456");

      ask(5);
    }
    if (index == object.hashFunc("C1412")) {
      System.out.println("C1412");

      ask(6);
    }
    if (index == object.hashFunc("C2412")) {
      System.out.println("C2412");

      ask(7);
    }
    if (index == object.hashFunc("C3457")) {
      System.out.println("C3457");

      ask(8);
    }
    if (index == object.hashFunc("D1789")) {
      System.out.println("D1789");

      ask(9);
    }
    if (index == object.hashFunc("D2456")) {
      System.out.println("D2456");

      ask(10);
    }
    if (index == object.hashFunc("D3896")) {
      System.out.println("D3896");

      ask(11);
    }
    if (index == object.hashFunc("E178*")) {
      System.out.println("E178*");

      ask(12);
    }
    if (index == object.hashFunc("E245#")) {
      System.out.println("E245#");

      ask(13);
    }
    if (index == object.hashFunc("E3141")) {
      System.out.println("E3141");

      ask(14);
    }
    if (index == object.hashFunc("Exit")&&objectName == "portal1") {
        System.out.println("DOne");

    }
    //  else if(index== object.hashFunc("guide")){
    //     set();
    //    i+=1;
    //  announce(inst[i]);

    //  if(i ==1 ){
    //     i = 0;
    //  }

    // }
         if(index== object.hashFunc("Exit")&&objectName == "door"){
            System.out.println(2);
           if(gp.player.coin == mapApp.getshortWeight()){
            gp.playSE("unlock");
            System.out.println("Success!");
            object.clear();
            objects.add(new portal1(),"Exit",151,41);
            gp.isGraph = false;
           }
           else{
             if(attemp == 2){
            announce("Wrong. Press R to reset");

        }
        else if(attemp == 1){
            announce("You have one try. Press R to reset");
    }
           }

        }

  }

  public void teleport() {
    teleport(g.getDestinationX(), g.getDestinationY());
    gp.player.setCoin(g.getMana());
  }

  //ask for teleport in quizzState.java
  public String annouces() {
    return announce;
  }

  public void ask(String name) {
    g.getEdges(name);
    announce =
      "Do you want to teleport " +
      g.getName() +
      " with " +
      g.getMana() +
      " coins ? ";
    gp.setGamestate(gp.quizzState);
  }

  public void ask(int index) {
    g.getEdges(index);
    System.out.println(g.getName());
    announce =
      "Do you want to teleport " +
      g.getName() +
      " with " +
      g.getMana() +
      " coins ? ";
    announce(announce);
  }

  public void keyBoard() {
    if (keyControl.mPress == true && press == true) {
      System.err.println(2);
      press = false;
    }
    if (keyControl.mPress == true && press == false) {
      System.err.println(3);

      press = true;
    }
  }

  public void openMap() {
    v = gp.v;
    getData();
    gp.openMap();
  }

  public void getData() {
    for (int i = 0; i < g.edges.size(); i++) {
      v.text.append(
        (i + 1) +
        ". " +
        g.edges.get(i).getSource().getId() +
        " to " +
        g.edges.get(i).getDestination().getId() +
        ". Coin: " +
        g.edges.get(i).getMana() +
        "\n"
      );
    }
  }

  public void reset() {
    attemp += 1;
    if (attemp == 2) {
      announce("You have reset the map");
      mapApp = null;
      graph();
    } else if (attemp == 1) {
      announce("You have one try");
    }
    teleport(166, 20); //back to begin}
  }
}
