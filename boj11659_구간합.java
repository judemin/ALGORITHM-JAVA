import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // buffeReader가 Scanner에 비해서 더 빠르기 때문에 사용
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력의 데이터가 int로 구분하기 어렵기 때문에 String Tokenizer 사용
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 숫자가 크면 습관적으로 long으로 선언한다
        // 합배열을 미리 만들어두어 구현한다
        long[] sum = new long[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++)
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(sum[end] - sum[start - 1]);
        }
    }
}
