import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("helpcross.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int chicken = Integer.parseInt(st.nextToken());
        int cow = Integer.parseInt(st.nextToken());
        ArrayList<Integer> chickens = new ArrayList<>();
        for (int i = 0; i < chicken; i++) {
            chickens.add(Integer.parseInt(br.readLine()));
        }
        ArrayList<Cow> cows = new ArrayList<>();
        for (int i = 0; i < cow; i++) {
            StringTokenizer stcow = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stcow.nextToken());
            int b = Integer.parseInt(stcow.nextToken());
            cows.add(new Cow(a, b));
        }
        Collections.sort(chickens);
        Collections.sort(cows);
        int count = 0;
        for (int i : chickens) {
            for (Cow c : cows) {
                if (i >= c.a && i <= c.b) {
                    cows.remove(c);
                    count++;
                    break;
                }
            }
        }
        pw.print(count);
        br.close();
        pw.close();
    }
}

class Cow implements Comparable<Cow>{
    int a;
    int b;
    public Cow(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public int compareTo(Cow o) {
        return Integer.compare(this.b,o.b);
    }
}
