import java.util.ArrayList; 
import java.util.Random;
import java.util.*;

public class CollectionTesting {
    
    public static void genArray(int size){

        int[] generate = new int[size];

        for(int i = 0; i < size; i++){
            
            int random = new Random().nextInt(10);
            
            generate[i] = random;

        }

    }

    public static void genList(int size){
       
        ArrayList<Integer> alist= new ArrayList<Integer>();
        int random;
 
         for(int i = 0; i < size; i++){
             
            random = new Random().nextInt(10);
             
             alist.add(random);    
         }   
    }

    public static void genVector(int size){
       
        Vector<Integer> v = new Vector<Integer>();
 
         for(int i = 0; i < size; i++){
             
            int random = new Random().nextInt(10);
             
            v.add(random); 
         } 
         
           
    }
    
    public static void addArray(int[] a){
      int total;
      for(int i = 0; i < a.size(); i++){
         
         total += a[i];
      }
    
    }


    public static void main(String[] args){
        
        double start = System.nanoTime();
        genArray(100000000);
        genArray(100000000);
        double end = System.nanoTime();
        Double total = end - start;
        total= total/1000000000.0;
        System.out.println("The total time for array is " + total);
        System.out.println("============================================================================");
        

        double start2 = System.nanoTime();
        genList(10000000);
        double end2 = System.nanoTime();
        Double total2 = end2 - start2;
        total2= total2/1000000000.0;
        System.out.println("The total time for arrayList is " + total2);
        System.out.println("============================================================================");

        
        double start3 = System.nanoTime();
        genVector(100000000);
        double end3 = System.nanoTime();
        Double total3 = end3 - start3;
        total3= total3/1000000000.0;
        System.out.println("The total time for vector is " + total3);
     
        
        
    }
    
}