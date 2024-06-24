import java.io.*;
import java.util.*;

class Pair {
    private int w;
    private int v;

    public Pair(int w, int v) {
        this.w = w;
        this.v = v;
    }

    public int getW() {
        return w;
    }

    public int getV() {
        return v;
    }
}

public class boj12865 {
    static int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    public static void main(String[] args) throws Exception {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N : 물건 개수, K : 버틸 수 있는 최대 무게
        int[][] dp = new int[N + 10][K + 10];
        for (i = 0; i <= N; i++)
            for (j = 0; j <= K; j++)
                dp[i][j] = 0;

        Pair[] wv = new Pair[N + 10];
        wv[0] = new Pair(0, 0);
        for (i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            wv[i] = new Pair(w, v);
        }

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= K; j++) {
                if (wv[i].getW() > j)
                    dp[i][j] = dp[i - 1][j];
                else if (wv[i].getW() <= j) {
                    dp[i][j] = max(dp[i - 1][j],
                            dp[i - 1][j - wv[i].getW()] + wv[i].getV());
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}