import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Instant start = Instant.now();
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("highcard.out"));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> opponent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            opponent.add(Integer.parseInt(br.readLine()));
        }
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> opponent1 = new ArrayList<>();
        for (int i = 1; i <= 2 * n; i++) {
            if (!opponent.contains(i)) {
                al.add(i);
            }
            else {
                opponent1.add(i);
            }
        }

//        for (int i = 0; i < opponent.size(); i++) {
//            System.out.print(opponent.get(i) + " ");
//        }
//        System.out.println("===============");
//        for (int i = 0; i < al.size(); i++) {
//            System.out.print(al.get(i) + " ");
//        }
        int count = 0;
//        Collections.sort(opponent);
//        Collections.sort(al);
        Instant afterSort = Instant.now();
        Long timeSort = Duration.between(start, afterSort).toMillis();
        System.out.println("time elapsed : " + timeSort);
//        for (int i = 0; i < n; i++) {
//            int op = opponent.get(i);
//            for (int j = temp; j < n; j++) {
//                if (al.get(j) > op) {
//                    count++;
//                    temp = j + 1;
//                    break;
//                }
//
//            }
//        }
        int bCount = 0;
        int eCount = 0;
        while (bCount < n && eCount < n) {
            if (al.get(bCount) > opponent1.get(eCount)) {
                count++;
                bCount++;
                eCount++;
            }
            else {
                bCount++;
            }
        }
        pw.print(count);
        br.close();
        pw.close();
    }
}
