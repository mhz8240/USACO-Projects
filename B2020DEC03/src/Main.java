import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] xA = new int[n];
        int[] yA = new int[n];
        char[] cA = new char[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            cA[i] = scanner.next().charAt(0);
            xA[i] = scanner.nextInt();
            yA[i] = scanner.nextInt();
        }
        Arrays.fill(result, Integer.MAX_VALUE);
        ArrayList<Integer> difference = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                difference.add(Math.abs(xA[i] - xA[j]));
                difference.add(Math.abs(yA[i] - yA[j]));
            }
        }
        Collections.sort(difference);
        for (int dif : difference) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cA[i] == 'E' && cA[j] == 'N' && xA[i] < xA[j] && yA[i] > yA[j])  {
                        if (xA[i] + dif == xA[j] && yA[j] + Math.min(result[j], dif) > yA[i]) {
                            result[i] = Math.min(result[i], dif);
                        }
                        else if(yA[j] + dif == yA[i] && xA[i] + Math.min(result[i], dif) > xA[j]) {
                            result[j] = Math.min(result[j], dif);
                        }
                    }
                }
            }
        }

        for (int i : result) {
            if (i == Integer.MAX_VALUE) {
                System.out.println("Infinity");
            }
            else {
                System.out.println(i);
            }
        }


//
//        for (int i = 0; i < n; i++) {
//            result[i] = 0;
//        }
//        for (int i = 0; i < n; i++) {
//            String str = scanner.nextLine();
//            String[] strA = str.split(" ");
//            iA[0][i] = Integer.parseInt(strA[1]);
//            iA[1][i] = Integer.parseInt(strA[2]);
//            sA[i] = strA[0];
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (!sA[i].equals(sA[j])) {
//                    if (sA[i].equals("E") && iA[0][i] < iA[0][j] && iA[1][i] > iA[1][j]) {
//                        int x = iA[0][j];
//                        int y = iA[1][i];
//                        if (x - iA[0][i] > y - iA[1][j]) {
//                            if (result[i] != 0) {
//                                if (x - iA[0][i] < result[i]) {
//                                    result[i] = x - iA[0][i];
//                                }
//                            } else {
//                                result[i] = x - iA[0][i];
//
//                            }
//                        } else if (x - iA[0][i] < y - iA[1][j]) {
//                            if (result[j] != 0) {
//                                if (y - iA[1][j] < result[j]) {
//                                    result[j] = y - iA[1][j];
//                                }
//                            } else {
//                                result[j] = y - iA[1][j];
//                            }
//                        }
//
//
//                    } else if (sA[i].equals("N") && iA[1][i] < iA[1][j] && iA[0][i] > iA[0][j]) {
//                        int x = iA[0][i];
//                        int y = iA[1][j];
//                        if (x - iA[0][j] > y - iA[1][i]) {
//                            if (result[j] != 0) {
//                                if (x - iA[0][j] < result[j]) {
//                                    result[j] = x - iA[0][j];
//                                }
//                            } else {
//                                result[j] = x - iA[0][j];
//                            }
//
//                        } else if (x - iA[0][j] < y - iA[1][i]) {
//                            if (result[i] != 0) {
//                                if (y - iA[1][i] < result[i]) {
//                                    result[i] = y - iA[1][i];
//                                }
//                            } else {
//                                result[i] = y - iA[1][i];
//                            }
//
//                        }
//                    }
//                }
//            }
//
//        }
//        int maxX = 0;
//        int maxY = 0;
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && iA[i][j] > maxX) {
//                    maxX = iA[i][j];
//                }
//                if (i == 1 && iA[i][j] > maxY) {
//                    maxY = iA[i][j];
//                }
//            }
//        }
//        boolean stop = false;
//        for (int i = 0; i < n; i++) {
//            stop = false;
//            int x = iA[0][i];
//            int y = iA[1][i];
//            int xPtr = x;
//            int yPtr = y;
//
//                xPtr = x;
//                yPtr = y;
//                if (sA[i].equals("E")) {
//                    while (true) {
//                        xPtr++;
//                        if (xPtr > maxX) {
//                            break;
//                        }
//                        for (int j = 0; j < n; j++) {
//                            if (sA[j].equals("N") && iA[0][j] == xPtr) {
//                                if (stop == false) {
//                                    if (result[i] == xPtr - x) {
//                                        stop = true;
//                                    }
//                                }
//                                else {
//                                    if (result[j] == iA[1][i] - iA[1][j]) {
//                                        result[j] = 0;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                if (sA[i].equals("N")) {
//                    while(true) {
//                        yPtr++;
//                        if (yPtr > maxY) {
//                            break;
//                        }
//                        for (int j = 0; j < n; j++) {
//                            if (sA[j].equals("E") && iA[1][j] == yPtr) {
//                                if (stop == false) {
//                                    if (result[i] == yPtr - y) {
//                                        stop = true;
//                                    }
//                                }
//                                else {
//                                    if (result[j] == iA[0][i] - iA[0][j]) {
//                                        result[j] = 0;
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//
//
//
//
//                }
//        }
//
//
//        for (int i : result) {
//            if (i == 0) {
//                System.out.println("Infinity");
//            }
//            else {
//                System.out.println(i);
//            }
//        }
    }
}
