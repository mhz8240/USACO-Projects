import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] iA = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            iA[i] = scanner.nextInt();
        }
        int sum;
        double average = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += iA[k];
                    }
                    average = (double)sum / (double)(j - i + 1);
                    for (int k = i; k <= j; k++) {
                        if (average == iA[k]) {
                            count++;
                            break;
                        }
                    }
                }
                if (i == j) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
