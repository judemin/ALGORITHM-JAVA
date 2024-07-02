
// boj23971
import java.io.*;
import java.util.*;

public class boj23971 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int resH = (H / (N + 1));
        if ((H % (N + 1)) != 0)
            resH++;
        int resW = (W / (M + 1));
        if ((W % (M + 1)) != 0)
            resW++;

        System.out.println(resH * resW);
    }
}