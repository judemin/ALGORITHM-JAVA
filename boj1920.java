import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        Arrays.sort(A);

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int start = 0;
            int end = N - 1;
            int target = sc.nextInt();
            while (start <= end) {
                int mid = (start + end) / 2;
                int value = A[mid];
                if (target < value) {
                    end = mid - 1;
                } else if (target > value) {
                    start = mid + 1;
                } else {
                    System.out.println("1");
                    find = true;
                    break;
                }
            }
            if (find == false)
                System.out.println("0");
        }
        sc.close();
    }
}