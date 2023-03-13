import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(str);
        int count = st.countTokens();
//        int count = 7;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(al);
        int a = al.get(0);
        int b = al.get(1);
        int max = al.get(count - 1);
//        for (int i : al) {
//            if (i > max) {
//                max = i;
//            }
//            if (i < a) {
//                int temp = a;
//                a = i;
//                b = temp;
//            }
//            else if (i < b) {
//                b = i;
//            }
//
//        }
        int c = max - a - b;
        System.out.println(a + " " + b + " " + c);

    }
}
