
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scanner = new Scanner(new File("socdist2.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("socdist2.out"));
        int n = scanner.nextInt();
        ArrayList<Cow> cow = new ArrayList<>();
//        int[] health = new int[n];
        for (int i = 0; i < n; i++) {
            cow.add(new Cow(scanner.nextInt(), scanner.nextInt()));
        }
        ArrayList<Cow> sortedCow = new ArrayList<>(cow);
        Collections.sort(sortedCow);
//        for (Cow c : sortedCow) {
//            System.out.println(c);
//        }
        int radius = Integer.MAX_VALUE;

        int start = 0;
        int startHealth = -1;
        for (Cow c : sortedCow) {
//            int index = 0;
//            for (int j = 0; j < n; j++) {
//                if (position.get(j) == i) {
//                    index = j;
//                }
//            }
            if (c.health == 1) {
                if (startHealth == -1) {
                    start = c.position;
                    startHealth = 1;
                }
                else if (startHealth == 0) {
                    int difference = c.position - start - 1;
                    if (difference < radius) {
                        radius = difference;
                    }
                    start = c.position;
                    startHealth = 1;
                }
                else if (startHealth == 1) {
                    start = c.position;
                }
            }
            else {
                if (startHealth == -1) {
                    start = c.position;
                    startHealth = 0;
                }
                else if (startHealth == 1) {
                    int difference = c.position - start - 1;
                    if (difference < radius) {
                        radius = difference;
                    }
                    start = c.position;
                    startHealth = 0;
                }
                else if (startHealth == 0) {
                    start = c.position;
                }
            }
        }
        start = -1;
        int count = 1;
        for (Cow c : sortedCow) {
//            int index = 0;
//            for (int j = 0; j < n; j++) {
//                if (position.get(j) == i) {
//                    index = j;
//                }
//            }
            if (c.health == 1) {
                if (start == -1) {
                    start = c.position;
                }
                else {
                    if (c.position - start > radius) {
                        count++;
                        start = c.position;
                    }
                    else {
                        start = c.position;
                    }

                }


            }

        }
        pw.println(count);
        pw.close();
    }
}

class Cow implements Comparable<Cow> {
    public int position;
    public int health;

    public Cow(int position, int health) {
        this.position = position;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "position=" + position +
                ", health=" + health +
                '}';
    }

    @Override
    public int compareTo(Cow o) {
        return this.position - o.position;
    }
}
