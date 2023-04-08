import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Main7 {

    public static void main(String[] args) {
        // Example usage of the three methods
        System.out.println("--------------------");
        System.out.println("We have a list of integers: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int countOfOdds = countElementsWithProperty(numbers, n -> n % 2 == 1);
        System.out.println("Count of odd numbers: " + countOfOdds);
        System.out.println("--------------------");

        System.out.println("We have a list of names: Alice, Bob, Charlie, Dave");

        String[] names = {"Alice", "Bob", "Charlie", "Dave"};
        swap(names, 1, 2);
        System.out.println("Names after swapping: " + Arrays.toString(names));
        System.out.println("--------------------");

        System.out.println("We have a list of doubles: 1.0, 2.5, -3.0, 4.5, 0.5");

        List<Double> values = Arrays.asList(1.0, 2.5, -3.0, 4.5, 0.5);
        Double maxInRange = findMax(values, 1, 4);
        System.out.println("Maximal value in range [1,4): " + maxInRange);
        System.out.println("--------------------");

    }

    public static <T> int countElementsWithProperty(Collection<T> collection, Predicate<T> predicate) {
        int count = 0;
        for (T element : collection) {
            if (predicate.test(element)) {
                count++;
            }
        }
        return count;
    }

    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T extends Comparable<? super T>> T findMax(List<T> list, int begin, int end) {
        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            T current = list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
