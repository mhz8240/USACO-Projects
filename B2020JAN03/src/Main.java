import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> cowHeights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cowHeights.add(scanner.nextInt());
        }
        ArrayList<Integer> barnHeights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            barnHeights.add(scanner.nextInt());
        }
        Collections.sort(cowHeights);
        Collections.sort(barnHeights);
        long permutations = 1;
        int count = 0;
        int num = 0;
        for (int i : barnHeights) {
            count = 0;
            count -= num;
            for (int j : cowHeights) {
                if (j <= i) {
                    count++;
                }


            }
            if (count < 0) {
                permutations = 0;
            }
            permutations *= count;
            num++;
        }
        System.out.println(permutations);
    }
}
