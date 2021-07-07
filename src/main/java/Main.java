import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final List<Integer> range = IntStream.rangeClosed(1, 1000)
            .boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        System.out.println("---------- Printing Random numbers between 1 and 1000. -------\n");
        printNumbersRandomly();

        int factorialInput = 5;
        System.out.printf("\n---------- Factorial of: %d ------- \n", factorialInput);
        System.out.println(func(factorialInput));
    }

  /**
   * I initially created a list that contains Ints from 1 to 1000;
   * Used Math.random with the current size.
   * List.remove returns the Index value and removes the item from the list.
   **/
  private static int returnRandomNumber() {
        int currentSize = range.size();
        int randomIndex = (int) (Math.random() * (currentSize));
        return range.remove(randomIndex);
    }

    // Just printing the random numbers until the list is depleted.
    private static void printNumbersRandomly(){
        while (!range.isEmpty()) {
            System.out.println(returnRandomNumber());
        }
    }

    // Factorial is the input number times itself -1 until it gets to the last state which is less then / equal 1.
    // This makes this a good candidate for an elegant recursive function.
    private static long func(int n){
        if (n <= 1){
            return 1;
        }
        return(n * func(n - 1));
    }
}
