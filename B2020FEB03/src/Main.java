import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
//        Scanner scanner = new Scanner(new File("swap.in"));
//        PrintWriter pw = new PrintWriter(new File("swap.out"));
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a1 = scanner.nextInt() - 1;
        int a2 = scanner.nextInt() - 1;
        int b1 = scanner.nextInt() - 1;
        int b2 = scanner.nextInt() - 1;
        int[] iA = new int[n];
        for (int i = 1; i <= n; i++) {
            iA[i - 1] = i;
        }
        for (int i = 0; i < k; i++) {
            int averageA = (a1 + a2) / 2;
            int countA = 0;
            int averageB = (b1 + b2) / 2;
            int countB = 0;
            for (int j = a1; j <= averageA; j++) {
                int temp = iA[j];
                iA[j] = iA[a2 - countA];
                iA[a2 - countA] = temp;
                countA++;
            }

            for (int j = b1; j <= averageB; j++) {
                int temp = iA[j];
                iA[j] = iA[b2 - countB];
                iA[b2 - countB] = temp;
                countB++;
            }
        }
        for (int i : iA) {
            pw.println(i);
        }

        scanner.close();
        pw.close();
    }
}
