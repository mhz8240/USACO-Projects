import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("reststops.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int distance = Integer.parseInt(st.nextToken());
        int numOfRests = Integer.parseInt(st.nextToken());
        long difference = Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken());
        ArrayList<Rest> rests = new ArrayList<>();
        for (int i = 0; i < numOfRests; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            long dist = Long.parseLong(st2.nextToken());
            long units = Long.parseLong(st2.nextToken());
            rests.add(new Rest(dist, units));
        }
        Collections.sort(rests);
        long count = 0;
        long length = 0;
        for (Rest r : rests) {
            if (length < r.distance) {
                count += (r.distance - length) * difference * r.units;
                length = r.distance;
            }
        }
        pw.print(count);
        br.close();
        pw.close();
    }
}

class Rest implements Comparable<Rest> {
    long distance;
    long units;

    public Rest(long distance, long units) {
        this.distance = distance;
        this.units = units;
    }

    @Override
    public int compareTo(Rest o) {
        if (Long.compare(this.units, o.units) != 0) {
            return Long.compare(this.units, o.units) * -1;
        }
        return Long.compare(this.distance, o.distance) * -1;
    }

    @Override
    public String toString() {
        return "Rest{" +
                "distance=" + distance +
                ", units=" + units +
                '}';
    }
}
