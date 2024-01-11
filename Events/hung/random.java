package Events.hung;

import java.util.Random;

/**
 * random
 */
public class random {

  private int[][] array = new int[7][4];
  public random() {
    create();
    print2DArray();
  }
  public int[][] getArray() {
      return array;
  }


  public static void main(String[] args) {
    int[][] a = new int[6][4];
    a[1][2] = 4;
    // print2DArray(a);
   random t = new random();


  }

   void print2DArray() {
    
    for (int i = 1; i <6; i++) {
      for (int j = 1; j < 4; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println(); // Move to the next line after printing a row
    }
  }

  public  int getRandom(int min,int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  void create() {
    for (int i = 1; i <6; i++) {
      for (int j = 1; j < 4; j++) {
        if(i == 1){
            array[i][j] = getRandom(1, 4);
        }
        if(i == 2){
            array[i][j] = getRandom(5, 8);
        }
         if(i == 3){
            array[i][j] = getRandom(9, 12);
        }
         if(i == 4){
            array[i][j] = getRandom(13, 16);
        }
         if(i == 5){
            array[i][j] = getRandom(17, 20);
        }
         
       
        
      }
    }
  }
}
