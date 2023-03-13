import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        long threeCount = 0;
        char prev = s.charAt(0);
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == prev) {
                count++;
            }
            else {
                count = 1;
            }
            prev = s.charAt(i);
            if (count >= 3) {
                threeCount++;
            }
        }
        long remove = s.length() - 2 - threeCount;
        System.out.println(remove);
    }
}
