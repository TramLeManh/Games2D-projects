package ScoreBoard;
public class players{
    String name;
    int score;
    public players(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        if(score != 0)
        return this.getName()+"\t"+this.getScore()+"\n";
        else
        return this.getName()+"\t      "+"\n";
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
}