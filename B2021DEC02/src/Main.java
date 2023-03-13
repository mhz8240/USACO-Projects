
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> preferred = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<Integer> difference = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            preferred.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            current.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            difference.add(preferred.get(i) - current.get(i));
        }
        System.out.println(count(difference));

    }
    public static int count (ArrayList<Integer> al) {
        int count = 0;
        boolean flag = true;
        int consecutive = 0;
        int prev = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            int val = al.get(i);
            if (val > 0) {
                if (prev > 0) {
                    list.add(val);
                    consecutive++;
                }
                else {
                    if (list.size() == 1) {
                        count += Math.abs(list.get(0));
                    }
                    if (list.size() > 1) {
                        int max = getMax(list);
                        for (int j = 0; j < list.size(); j++) {
                            list.set(j, list.get(j) - max);
                        }
                        count += Math.abs(max);
                        count += count(list);

                    }
                    list.clear();
                    list.add(val);
                    consecutive = 1;
                }
                flag = true;
            }
            if (val < 0) {
                if (prev >= 0) {
                    if (list.size() == 1) {
                        count += list.get(0);
                    }
                    if (list.size() > 1) {
                        int min = getMin(list);
                        for (int j = 0; j < list.size(); j++) {
                            list.set(j, list.get(j) - min);
                        }
                        count += min;
                        count += count(list);

                    }
                    list.clear();
                    list.add(val);
                    consecutive = 1;
                }
                else {
                    list.add(val);
                    consecutive++;
                }
                flag = false;
            }
            if (val == 0) {
                if (list.size() == 1) {
                    count += Math.abs(list.get(0));
                }
                if (list.size() > 1) {
                    if (prev > 0) {
                        int min = getMin(list);
                        for (int j = 0; j < list.size(); j++) {
                            list.set(j, list.get(j) - min);
                        }
                        count += min;
                        count += count(list);
                    }
                    if (prev < 0) {
                        int max = getMax(list);
                        for (int j = 0; j < list.size(); j++) {
                            list.set(j, list.get(j) - max);
                        }
                        count += Math.abs(max);
                        count += count(list);

                    }

                }
                list.clear();
                consecutive = 0;
                prev = 0;
                flag = false;
            }
            if (i == al.size() - 1) {
                if (list.size() == 1) {
                    count += Math.abs(list.get(0));
                }
                if (list.size() > 1) {
                    if (prev > 0) {
                        int min = getMin(list);
                        for (int j = 0; j < list.size(); j++) {
                            list.set(j, list.get(j) - min);
                        }
                        count += min;
                        count += count(list);
                    }
                    if (prev < 0) {
                        int max = getMax(list);
                        for (int j = 0; j < list.size(); j++) {
                            list.set(j, list.get(j) - max);
                        }
                        count += Math.abs(max);
                        count += count(list);

                    }

                }
            }
            prev = val;
        }
        return count;
    }
    public static int getMin(ArrayList<Integer> al) {
        int min = Integer.MAX_VALUE;
        for (int i : al) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
    public static int getMax(ArrayList<Integer> al) {
        int max = Integer.MIN_VALUE;
        for (int i : al) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
