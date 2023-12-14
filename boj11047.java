import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int A[] = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        // Greedy - 최대한 큰 동전 먼저 써주기
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                cnt += (K / A[i]);
                K = K % A[i];
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}