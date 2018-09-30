
import java.util.*;

public class Vector{

   public static void genVector(int size){
       
       Vector v = new Vector();
       int random;

        for(int i = 0; i < size; i++){
            
           random = new Random().nextInt(10);
            
           v.add(random);    
        }   
   }
   public static void main(String[]args){
      double start = System.nanoTime();
      genVector(100);
      double end = System.nanoTime();
      Double total = end - start;
      total= total/1000000000.0;
      System.out.println("The total time for array is " + total);
   }

}