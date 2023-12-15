import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(bf.readLine());
        for (int t = 0; t < testNum; t++) {
            String[] s = bf.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 2];
            check = new int[V + 2];
            visited = new boolean[V + 2];
            isEven = true;
            for (int i = 1; i <= V; i++)
                A[i] = new ArrayList<Integer>();
            // Edge 데이터 저장하기
            for (int i = 0; i < E; i++) {
                s = bf.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            // 모든 Node에 대해 DFS 실행
            for (int i = 0; i <= V; i++) {
                if (isEven) {
                    DFS(1);
                } else {
                    break;
                }
            }

            if (isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        // node에 연결된 모든 인접 노드 탐색
        for (int i : A[node]) {
            if (!visited[i]) {
                // 직전 노드와 다른 집합으로 분류
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}