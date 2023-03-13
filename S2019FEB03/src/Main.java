import java.io.*;
import java.util.StringTokenizer;

public class Main {
static int pastures;
static int cows;
static int[] parent;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pastures = Integer.parseInt(st.nextToken());
        cows = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cows; i++) {
            StringTokenizer stCows = new StringTokenizer(br.readLine());
            int 
            union()
        }
    }

    public static void union(int a, int b) {
        int c = find(a);
        int d = find(b);
        if (c != d) {
            parent[d-1] = c;
        }

    }

    public static int find (int x) {
        if (x == parent[x-1]) {
            return x;
        }
        else {
            return parent[x-1] = find(parent[x-1]);
        }
    }
}
