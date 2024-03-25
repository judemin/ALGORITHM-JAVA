import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N + 1];

        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        // Bubble Sort
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }

            }
        }

        for (int i = 0; i < N; i++)
            System.out.println(A[i]);
        sc.close();
    }
}