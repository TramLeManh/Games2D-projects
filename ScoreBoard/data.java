package ScoreBoard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class data {
    
   players[] players = null;
    int elements;
    public data() {
    }
    public players[] getData(){
         get1();
       
        return  players;
    }
    public int getSize(){
      
        players = new players[100];
        Connection connection = connect();
        String sql = "SELECT count(*) FROM account";
        int count = 0;

        //Java connect SQL
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while(rs.next()) {
               return (rs.getInt(1));
    
            }}
        catch (Exception e) {
            System.out.println("error");
        }
        return -1;

    }
    public void get1(){
          players = new players[100];

           players[0] = new players("a1",1);
                players[1] = new players("a2",2);
                players[2] = new players("a3",3);
                        players[3] = new players("a4",4);

    }

    public void get(){
        players = new players[100];
        Connection connection = connect();
        String sql = "SELECT * FROM account";
         elements= 0;

        //Java connect SQL
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while(rs.next()) {
                players[elements] = new players(rs.getString(1), rs.getInt(3));///add players to array
                elements += 1;
           
            }}
        catch (Exception e) {
            System.out.println("error");
        }
    }
    


public  Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","Lemanh@1412");

        } catch (ClassNotFoundException|SQLException e){
            
            System.out.println(e);

            }

            return connection;
        }

public static void main(String[] args) {
    players[] players = new data().getData();
    System.out.println(players[3].toString());
    data d = new data();
    System.out.println(d.getSize());
}

}
