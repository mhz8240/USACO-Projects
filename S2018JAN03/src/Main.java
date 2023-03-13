import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int count = 0;
    static ArrayList<Boolean> visited = new ArrayList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mootube.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int questions = Integer.parseInt(st.nextToken());
        for (int i = 0; i < nodes; i++) {
            edges.add(new ArrayList<Edge>());
        }
        for (int i = 1; i < nodes; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int relevance = Integer.parseInt(st2.nextToken());
            edges.get(a - 1).add(new Edge(b, relevance));
            edges.get(b-1).add(new Edge(a, relevance));
        }
        ArrayList<Question> questionArray = new ArrayList<>();
        for (int i = 0; i < questions; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            questionArray.add(new Question(b, a));
        }
        for (int i = 0; i < nodes; i++) {
            visited.add(false);
        }
        for (Question question : questionArray) {
            for (int i = 0; i < nodes; i++) {
                visited.set(i, false);
            }
            count = 0;
            dfs(question.node, question.relevance);
            pw.println(count);
        }
        br.close();
        pw.close();
//        int count = 0;
//        for (ArrayList<Edge> edge : edges) {
//            System.out.println(count);
//            for (Edge e : edge) {
//                System.out.println(e);
//
//            }
//            count++;
//        }
    }
    public static void dfs (int node, int relevance) {
        visited.set(node-1, true);
        for (Edge edge : edges.get(node - 1)) {
            if (edge.rel >= relevance && visited.get(edge.destination-1) == false ) {
                count++;
                dfs(edge.destination, relevance);
            }
        }
    }
}

class Edge {
    int destination;
    int rel;
    public Edge(int destination, int rel) {
        this.destination = destination;
        this.rel = rel;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", rel=" + rel +
                '}';
    }
}

class Question {
    int node;
    int relevance;

    public Question(int node, int relevance) {
        this.node = node;
        this.relevance = relevance;
    }

    @Override
    public String toString() {
        return "Question{" +
                "node=" + node +
                ", relevance=" + relevance +
                '}';
    }
}