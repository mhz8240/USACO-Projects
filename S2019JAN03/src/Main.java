import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mountains.out"));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Mountain> mountains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            mountains.add(new Mountain(x,y));
        }
        Collections.sort(mountains);
        for (int i = 0; i < mountains.size(); i++) {
            for (int j = i + 1; j < mountains.size(); j++) {
                if (within(mountains.get(i),mountains.get(j))) {
                    mountains.remove(j);
                    j--;
                }
            }
        }
        pw.print(mountains.size());
        br.close();
        pw.close();
    }

    public static boolean within (Mountain m1, Mountain m2) {
        if ((m1.y - m2.y) >= Math.abs(m1.x - m2.x)) {
            return true;
        }
        return false;
    }
}

class Mountain implements Comparable<Mountain>{
    int x;
    int y;

    public Mountain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Mountain o) {
        return Integer.compare(this.y, o.y) * -1;
    }
}
