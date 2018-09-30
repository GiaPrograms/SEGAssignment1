import java.util.Random;

public class CollectionTesting {
    
    public static void genArray(int size){

        int[] generate = new int[size];

        for(int i = 0; i < size; i++){
            
            int random = new Random().nextInt(10);
            
            generate[i] = random;

        }

    }
    public static void main(String[] args){

        double start = System.nanoTime();
        genArray(1000000);
        double end = System.nanoTime();
        Double total = end - start;

        System.out.println("The total time for array is " + total);

    }
}