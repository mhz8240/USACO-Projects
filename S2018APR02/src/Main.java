import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
//        BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("lemonade.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.countTokens();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(al, Collections.reverseOrder());
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (al.get(i) >= k) {
                k++;
            }
            else {
                break;
            }
        }

        pw.println(k);
        br.close();
        pw.close();
    }
}
