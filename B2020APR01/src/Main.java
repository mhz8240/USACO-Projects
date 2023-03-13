import java.io.*;

public class Main {

    private static Object IOException;

    public static void main(String[] args) {
	// write your code here
        BufferedReader br;
        PrintWriter pw;
        try {
            br = new BufferedReader(new FileReader("socdist1.in"));
            pw = new PrintWriter(new FileWriter("socdist1.out"));
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int[] iA = new int[n];
            for (int i = 0; i < n; i++) {
                iA[i] = Integer.parseInt(str.substring(i,i + 1));
            }
            int max1 = 0;
            int max2 = 0;
            int count = 0;
            int index = 0;
            int minCount = 0;
            boolean flag = false;
            minCount = Integer.MAX_VALUE;
            for (int i : iA) {

                if (flag == true) {
                    if (i == 0) {
                        count++;
                    }
                    if (i == 1) {
                        if (count < minCount) {
                            minCount = count;
                        }
                        count = 0;
                    }
                }
                if (i == 1) {
                    flag = true;
                }


            }
            int begin = 0;
            int end = 0;
            for (int i : iA) {
                if (i == 1) {
                    break;
                }
                if (i == 0) {
                    begin++;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (iA[i] == 1) {
                    break;
                }
                if (iA[i] == 0) {
                    end++;
                }
            }
            boolean edge = true;
            count = 0;
            for (int i : iA) {
                if (index == 0) {
                    if (i == 0) {
                        count++;
                    }
                }
                else if(iA[index - 1] == 0 && i == 1) {
                    if (edge == false) {
                        if (count > max1) {
                            int temp = max1;
                            max1 = count;
                            max2 = temp;
                        }
                        else if (count > max2) {
                            max2 = count;

                        }
                    }

                    count = 0;

                }
                else if(i == 0) {
                    count++;
                }
                if (i == 1) {
                    edge = false;
                }
                index++;
            }
            if (begin <= minCount && end <= minCount && minCount != Integer.MAX_VALUE) {
                if ((max1 - 2) / 3 > (max2 - 1) / 2) {
                    if ((max1 - 2) / 3 > minCount) {
                        pw.println(minCount + 1);
                    }
                    else {
                        pw.println((max1 - 2) / 3 + 1);
                    }
                }
                else {
                    if ((max2 - 1) / 2 > minCount) {
                        pw.println(minCount + 1);
                    }
                    else {
                        pw.println((max2 - 1) / 2 + 1);
                    }
                }
            }
            else if(end <= minCount && minCount != Integer.MAX_VALUE) {
                if (max1 >= begin - 1) {
                    if ((max1 - 1) / 2 > minCount) {
                        pw.println(minCount + 1);
                    }
                    else {
                        pw.println((max1 - 1) / 2 + 1);
                    }
                }
                else {
                    if ((begin - 2) / 2 > minCount) {
                        pw.println(minCount + 1);
                    }
                    else {
                        pw.println((begin - 2) / 2 + 1);
                    }
                }
            }
            else if(begin <= minCount && minCount != Integer.MAX_VALUE) {
                if (max1 >= end - 1) {
                    if ((max1 - 1) / 2 > minCount) {
                        pw.println(minCount + 1);
                    }
                    else {
                        pw.println((max1 - 1) / 2 + 1);
                    }
                }
                else {
                    if ((end - 2) / 2 > minCount) {
                        pw.println(minCount + 1);
                    }
                    else {
                        pw.println((end - 2) / 2 + 1);
                    }
                }

            }
            else if (minCount != Integer.MAX_VALUE) {
                if (begin >= end) {
                    if (max1 >= begin - 1) {
                        if (max1 > minCount) {
                            pw.println(minCount + 1);
                        }
                        else {
                            pw.println(max1 + 1);
                        }

                    }
                    else {
                        if (begin - 1 > minCount) {
                            pw.println(minCount + 1);
                        }
                        else {
                            pw.println(begin);
                        }
                    }
                }
                else {
                    if (max1 >= end - 1) {
                        if (max1 > minCount) {
                            pw.println(minCount + 1);
                        }
                        else {
                            pw.println(max1 + 1);
                        }

                    }
                    else {
                        if (end - 1 > minCount) {
                            pw.println(minCount + 1);
                        }
                        else {
                            pw.println(end);
                        }
                    }
                }
            }
            else {
                int num = n;
                for (int i = 0; i < n; i++) {
                    if (iA[i] == 1) {
                        num = i + 1;
                    }
                }
                if (num == n) {
                    pw.println(n - 1);
                }
                else {
                    if (3 * num <= n)  {
                        pw.println(num + (n - 3 * num) / 2);
                    }
                    else if ((n - num + 1) * 3 <= n) {
                        pw.println((num - 1) / 2);
                    }
                    else {
                        if (num - 1 >= n - num) {
                            pw.println(n - num);
                        }
                        else {
                            pw.println(num - 1);
                        }
                    }

                }
            }
            br.close();
            pw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
