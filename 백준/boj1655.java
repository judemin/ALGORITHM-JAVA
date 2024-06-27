
// 시간초과 실패
import java.io.*;
import java.util.*;

public class boj1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // st로 시간초과 해결
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (maxPQ.size() == minPQ.size()) {
                maxPQ.add(num);
            } else {
                minPQ.add(num);
            }

            if (!minPQ.isEmpty() && (maxPQ.peek() > minPQ.peek())) {
                minPQ.add(maxPQ.poll());
                maxPQ.add(minPQ.poll());
            }

            System.out.println(maxPQ.peek());
        }
    }
}
