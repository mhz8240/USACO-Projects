import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] iArray = new int[n];
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            iArray[i] = scanner.nextInt() % 2;
        }
        for (int i : iArray) {
            if (i == 0) {
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }
        int count = 0;
        while (true) {
            int mod = count % 2;
            if (mod == 0) {
                if (zeroCount > 0) {
                    count++;
                    zeroCount--;
                }
                else {
                    count++;
                    oneCount = oneCount - 2;
                }
            }
            else {
                if (zeroCount > 0) {
                    if (oneCount > 0) {
                        count++;
                        oneCount--;
                    }
                    else {
                        break;
                    }
                }
                else {
                    if (oneCount % 3 == 2) {
                        count =  count + (int)((double)(oneCount - 2) / 1.5);

                    }
                    else if (oneCount % 3 == 0){
                        count =  count + (int)((double)(oneCount) / 1.5);
                    }
                    else {
                        count = count + 1 + (int)((double)(oneCount - 1) / 1.5);
                    }
                    break;
                }
            }

        }
        System.out.println(count);


    }
}
