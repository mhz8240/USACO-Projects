import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Boolean> isVisited = new ArrayList<>();
    static boolean flag2 = false;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
    static String breeds;
    static int count;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int farm = Integer.parseInt(st.nextToken());
        int friend = Integer.parseInt(st.nextToken());
        breeds = br.readLine();
        for (int i = 0; i < farm; i++) {
            adj.add(new ArrayList<Node>());
        }
        for (int i = 1; i < farm; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            adj.get(x-1).add(new Node(y, breeds.charAt(y-1)));
            adj.get(y-1).add(new Node(x, breeds.charAt(x-1)));
        }
//        int count = 0;
//        for (ArrayList<Node> nodes : adj) {
//            System.out.println(count);
//            for (Node node : nodes) {
//                System.out.println(node);
//            }
//            count++;
//        }

        for (int i = 0; i < farm; i++) {
            isVisited.add(false);
        }
        for (int i = 0; i < friend; i++) {
            count++;
            flag2 = false;
            for (int j = 0; j < farm; j++) {
                isVisited.set(j, false);
            }
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            char c = st3.nextToken().charAt(0);
            if (breeds.charAt(a-1) == c) {
                pw.print(1);
            }
            else {
                dfs(a, b, c, false);
                if (flag2) {
                    pw.print(1);
                }
                else {
                    pw.print(0);
                }
            }

        }
        br.close();
        pw.close();
    }


    public static void dfs(int a, int b, char c, boolean flag) {
        if (flag2) {
            return;
        }
        isVisited.set(a - 1, true);
        if (a == b) {
            if (flag == true) {
                flag2 = true;
                return;
            }
            flag2 = false;
            return;
        }
        for (Node node : adj.get(a-1)) {
            if (isVisited.get(node.x - 1) == false) {
                if (breeds.charAt(node.x - 1) == c && flag == false) {
                    dfs(node.x, b, c, true);
                }
                else {
                    dfs(node.x, b, c, flag);
                }
            }
        }
    }
}

class Node {
    int x;
    char s;

    public Node(int x, char s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", s=" + s +
                '}';
    }
}
