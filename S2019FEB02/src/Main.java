import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int rectangles;
    static int coats;
    static int[][] prefixSum;
    static int xMax;
    static int yMax;
    static int count;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("paintbarn.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rectangles = Integer.parseInt(st.nextToken());
        coats = Integer.parseInt(st.nextToken());
//        prefixSum = new int[1001][1001];
        prefixSum = new int[1001][1001];
        for (int i = 0; i < rectangles; i++) {
            StringTokenizer stRect = new StringTokenizer(br.readLine());
            int minX = Integer.parseInt(stRect.nextToken());
            int minY = Integer.parseInt(stRect.nextToken());
            int maxX = Integer.parseInt(stRect.nextToken());
            int maxY = Integer.parseInt(stRect.nextToken());
            prefixSum[minX][minY]++;
            prefixSum[maxX][maxY]++;
            prefixSum[minX][maxY]--;
            prefixSum[maxX][minY]--;
            if (maxX > xMax) {
                xMax = maxX;
            }
            if (maxY > yMax) {
                yMax = maxY;
            }
        }
        for (int i = 1; i < xMax; i++) {
            prefixSum[i][0] = prefixSum[i-1][0] + prefixSum[i][0];
        }
        for (int i = 1; i < yMax; i++) {
            prefixSum[0][i] = prefixSum[0][i-1] + prefixSum[0][i];
        }
        prefixSum();
        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                if (prefixSum[j][i] == coats) {
                    count++;
                }
            }
        }
        pw.print(count);
        br.close();
        pw.close();

    }
    public static void prefixSum() {
        for (int i = 1; i < yMax; i++) {
            for (int j = 1; j < xMax; j++) {
                prefixSum[j][i] = prefixSum[j][i] + prefixSum[j-1][i] + prefixSum[j][i-1] - prefixSum[j-1][i-1];
            }
        }
    }
}
