package Events.pickObjects;

public class oldman {
    private pickObjects p;
    public oldman() {
    }
    public void set(pickObjects p,int index){
        if (index == 32) {
            if (!p.isHaveToothpaste()) {
                p.announce("I lost the toothpaste. Can you please find it ?");
            } else {
                if (p.player.speed == 4) {
                    p.announce("Thank you. Have a nice day.");
                    p.gp.playSE("clear");
                    p.clear();
                }
                else if (p.player.speed == 3) {
                    p.announce("Thank you. Here is spped power as gift");
                    p.ModeSpeed(1);
                    p.gp.playSE("clear");
                    p.clear();
                }
                else if (p.player.speed == 2&&p.gp.object[42]!=null) {
                    p.announce("Thank you. Here is spped power as gift");
                    p.ModeSpeed(1);
                    p.gp.playSE("clear");
                    p.clear();
                }
            }

        } else {
            if(p.isMan){
                if(p.isDoll==false&&((p.Keys()==1)||(p.Keys()==0))){
                    p.announce("Hello, there is something in the lava");
                    p.Key2();
                    p.isMan = false;
                }
              
                else if(p.isDoll==true&&p.Keys()==0){
                    p.announce("Hello the adventure, there is something in the lava");
                    p.Key2();
                }
                else if ((p.gp.object[41] == null) && (p.gp.object[42] == null) &&(p.Keys() == 1||p.Keys()==0)&&p.isDoll==false) {
                    p.announce("You again. Here is your last key . \n I hope you do not lost it");
                    p.addKey();
                    p.isMan = false;    
                }
                else{
                    p.announce("It's a lovely day");

                }

            }else{
                p.announce("It's a lovely day");

            }
            
        }
    }
    
}
