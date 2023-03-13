import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scanner = new Scanner(new File("socdist1.in"));
        PrintWriter pw = new PrintWriter(new File("socdist1.out"));

        int n = scanner.nextInt();
        String str = scanner.next();
//        System.out.println("n = " + n);
//        System.out.println("str = " + str);
//        pw.println("n = " + n);
//        pw.println("str = " + str);
        int top1 = 1;
        int top2 = 1;
        int topadd2 = 1;
        int gapstart = -1;
        int currd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {


            if (str.charAt(i) == '1') {
                if (gapstart == -1) {
                    top1 = Math.max(top1, i);
                    topadd2 = Math.max(topadd2, i / 2);
                    gapstart = i;
                }
                else {
                    int j = (i - gapstart) / 2;
                    if (j >= top1) {
                        top2 = top1;
                        top1 = j;

                    }
                    else if (j > top2) {
                        top2 = j;
                    }
                    topadd2 = Math.max(topadd2, (i - gapstart) / 3);
                    currd = Math.min(i - gapstart, currd);
                    gapstart = i;
                }
            }

        }
        if (gapstart == -1) {
            pw.println(n - 1);
        }
        else {
            int j = n - gapstart - 1;
            if (j > top1) {
                top2 = top1;
                top1 = j;

            }
            else if (j > top2) {
                top2 = j;
            }
            topadd2 = Math.max(topadd2, (n - gapstart - 1) / 2);
//            System.out.println(top1 + " " + top2 + " " + topadd2 + " " + currd);
//            System.out.println(Math.min(currd, Math.max(topadd2, Math.min(top1, top2))));
            pw.println(Math.min(currd, Math.max(topadd2, Math.min(top1, top2))));
        }




        // close
        pw.close();
        scanner.close();
    }
}
