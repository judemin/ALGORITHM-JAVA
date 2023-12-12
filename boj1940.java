import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        // 빠른 입력을 위해 BufferedReader
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // Java의 내장 Array sort
        Arrays.sort(A);

        int count = 0;
        int start = 0; // MIN
        int end = N - 1; // MAX
        while (start < end) {
            if (A[start] + A[end] < M)
                start++;
            else if (A[start] + A[end] > M)
                end--;
            else {
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
    }
}