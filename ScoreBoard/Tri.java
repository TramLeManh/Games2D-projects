package ScoreBoard;

public class Tri {
    private score score;
    players[] Players_list = null;
    int elements = 0;
    public Tri(score score) {
        data data = new data();

        Players_list=  data. getData();
        this.elements = data.getSize();
        sort();
        this.score = score;
      
       
    }
    public void execute(){
        for(int i = 0; i <elements; i++){
            if(Players_list[i]!=null){
                        score.text.append(i+Players_list[i].toString());
            }
        }
    }
    public void sort() {
        int i, j;

        boolean swapped;
        for (i = 0; i < elements- 1; i++) {
            swapped = false;
            for (j = 0; j < elements - i - 1; j++) {
                if ( Players_list[j].getScore() <  Players_list[j + 1].getScore()) {
                    // Swap arr[j] and arr[j+1]
                    players p1 = Players_list[j];
                    this.Swap(Players_list[j], Players_list[j+1]);
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    public void create(String  name) {
    
        players p = new players( name,0);
        Players_list [elements] = p;
        elements++;
        sort();
    }

    public int rank(players p ){
        int rank  = 0;
        return rank;
    }
    public void remove(players p){
        int foundIndex = -1;
        for(int i = 0 ; i < elements ; i++){
             if(Players_list[i] != null && Players_list[i].getName().equals(p.getName())){
                   // Generate shift all the value after delete
                   foundIndex = i;
                   break;
             }
        }
        if(foundIndex!=-1){
            for (int i = foundIndex; i < elements - 1; i++) {
                Players_list[i] = Players_list[i + 1];
            }
            Players_list[elements - 1] = null;
        }else{
            System.out.println("Player not found" + p.getName());
        }
    }
    public void Swap(players p1 , players p2){
        int tempScore = p1.getScore();
        String tempName = p1.getName();

        p1.setScore(p2.getScore());
        p1.setName(p2.getName());

        p2.setScore(tempScore);
        p2.setName(tempName);
    }


}