import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String heard = scanner.nextLine();
        char[] cArray = new char[s.length()];
        char[] heardArray = new char[heard.length()];
        for (int i = 0; i < s.length(); i++) {
            cArray[i] = s.charAt(i);
        }
        for (int i = 0; i < heard.length(); i++) {
            heardArray[i] = heard.charAt(i);
        }
        int count = 1;
        int index = -1;
        for (char c : heardArray) {
            if (s.indexOf(c) <= index) {
                count++;
                index = s.indexOf(c);
            }
            else {
                index = s.indexOf(c);
            }

        }
        System.out.println(count);
    }
}
