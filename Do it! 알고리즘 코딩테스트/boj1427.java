import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
            A[i] = Integer.parseInt(str.substring(i, i + 1));

        // Selection Sort
        for (int i = 0; i < str.length(); i++) {
            int MAX = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[MAX])
                    MAX = j;
            }
            if (A[i] < A[MAX]) {
                int tmp = A[i];
                A[i] = A[MAX];
                A[MAX] = tmp;
            }
        }

        for (int i = 0; i < str.length(); i++)
            System.out.print(A[i]);
    }
}