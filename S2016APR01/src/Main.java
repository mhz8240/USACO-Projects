import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("reduce.out"));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Cow> cows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
//        cows.forEach(System.out::println);
//        Collections.sort(cows, new CompareCowX());
//        cows.forEach(System.out::println);
//        Collections.sort(cows, new CompareCowY());
//        cows.forEach(System.out::println);
        ArrayList<Cow> cowClone = null;
        cowClone = (ArrayList<Cow>) cows.clone();
        int minR = Integer.MAX_VALUE;
        for (int highX = 0; highX < 4; highX++) {
            for (int lowX = 0; lowX < 4; lowX++) {
                for (int highY = 0; highY < 4; highY++) {
                    for (int lowY = 0; lowY < 4; lowY++) {
                        if (highX + lowX + highY + lowY == 3) {
                            cowClone = (ArrayList<Cow>) cows.clone();
                            Collections.sort(cowClone, new CompareCowX());
                            for (int i = 0; i < highX; i++) {
                                cowClone.remove(cowClone.size() - 1);
                            }
                            for (int i = 0; i < lowX; i++) {
                                cowClone.remove(0);
                            }
                            int xDiff = cowClone.get(cowClone.size() - 1).x - cowClone.get(0).x;

                            Collections.sort(cowClone, new CompareCowY());
                            for (int i = 0; i < highY; i++) {
                                cowClone.remove(cowClone.size() - 1);
                            }
                            for (int i = 0; i < lowY; i++) {
                                cowClone.remove(0);
                            }
                            int yDiff = cowClone.get(cowClone.size() - 1).y - cowClone.get(0).y;
                            int area = xDiff * yDiff;
                            if (area < minR) {
                                minR = area;
                            }
                        }
                    }
                }
            }
        }
        pw.print(minR);
        //
        br.close();
        pw.close();
    }
}
class Cow {
    public Integer x;
    public Integer y;

    public Cow(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class CompareCowX implements Comparator<Cow> {

    @Override
    public int compare(Cow o1, Cow o2) {
        return o1.x.compareTo(o2.x);
    }
}
class CompareCowY implements Comparator<Cow> {

    @Override
    public int compare(Cow o1, Cow o2) {
        return o1.y.compareTo(o2.y);
    }
}