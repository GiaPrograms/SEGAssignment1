import java.util.ArrayList; 
import java.util.Random;

public class List{

   public static void genList(int size){
       
       ArrayList<Integer> alist= new ArrayList<Integer>();
       int random;

        for(int i = 0; i < size; i++){
            
           random = new Random().nextInt(10);
            
            alist.add(random);    
        }   
   }
   public static void main(String[]args){
      double start = System.nanoTime();
      genList(100000000);
      double end = System.nanoTime();
      Double total = end - start;
      total= total/1000000000.0;
      System.out.println("The total time for array is " + total);
   }

}