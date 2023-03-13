import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("wormsort.out"));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int cow = Integer.parseInt(st1.nextToken());
        int wormhole = Integer.parseInt(st1.nextToken());
        ArrayList<Integer> al = new ArrayList<>();
        StringTokenizer stOrder = new StringTokenizer(br.readLine());
        for (int i = 0; i < cow; i++) {
            al.add(Integer.parseInt(stOrder.nextToken()));
        }
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < wormhole; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            int weight = Integer.parseInt(st3.nextToken());
            edges.add(new Edge(a, b, weight));
        }
        Collections.sort(edges);
        ArrayList<Integer> required = new ArrayList<>();
        for (int i : al) {
            if (al.indexOf(i) + 1 != i) {
                required.add(i);
            }
        }
//        ArrayList<Integer> total = new ArrayList<>();
//        for (int i = 0; i < cow; i++) {
//            total.add(0);
//        }
        for (int i = 0; i < cow; i++) {
            parent[i] = i + 1;
        }
        for (Edge e : edges) {
            union(e.a, e.b);

        }
    }
    public static boolean reversible() {

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

class Edge implements Comparable<Edge>{
    int a;
    int b;
    int weight;

    public Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight) * -1;
    }
}
