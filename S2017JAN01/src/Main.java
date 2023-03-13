import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int cow;
    static int maxTime;
    static int left = 0;
    static int right;
    static ArrayList<Integer> cows = new ArrayList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowdance.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cow = Integer.parseInt(st.nextToken());
        maxTime = Integer.parseInt(st.nextToken());
        right = cow;
        for (int i = 0; i < cow; i++) {
            cows.add(Integer.parseInt(br.readLine()));
        }
        int ans = bst();
        pw.print(ans);
        br.close();
        pw.close();
    }

    public static int bst() {
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (!check(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static boolean check(int mid) {
        ArrayList<Integer> stage = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            stage.add(cows.get(i));
        }
        for (int i = mid; i < cow; i++) {
            int min = Collections.min(stage);
            Object o = min;
            stage.remove(o);
            stage.add(min + cows.get(i));
            int max = Collections.max(stage);
            if (max > maxTime) {
                return false;
            }
        }
        return true;
    }
}
