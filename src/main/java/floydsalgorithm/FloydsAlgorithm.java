package floydsalgorithm;

import java.io.PrintWriter;
import java.util.*;

public class FloydsAlgorithm {

    /*
     * Robert Floyd's Algorithm for Sampling without Replacement
     *
     * Efficiently selects set of k random numbers from n numbers with equal probability.
     *
     * Examples:
     *
     * Select 3 random numbers from 5 numbers [0, 5) = [1, 2, 4]
     *
     * Select 5 random numbers from 100,000,000 = [34862643, 18068407, 30301144, 92804469, 75385441]
     *
     */
    private static Set<Integer> select(int n, int k) {
        if (k > n) {
            throw new IllegalArgumentException("k must be <= n");
        }

        Set<Integer> selected = new HashSet<>();

        Random random = new Random();

        for (int i = n - k; i < n; i++) {
            //int t = (int) (Math.random() * (i + 1));
            int t = random.nextInt(i + 1);
            if (!selected.contains(t)) {
                selected.add(t);
            } else {
                selected.add(i);
            }
        }

        return selected;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type n: ");
        int n = scanner.nextInt();

        System.out.println("Type k: ");
        int k = scanner.nextInt();

        Set<Integer> set = select(n, k);
        System.out.println("Random set: ");
        System.out.println(set);
    }
}