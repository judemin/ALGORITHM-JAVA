import java.util.Scanner;

public class Main {
    static int parent[];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 2];
        // 대표노드 초기화
        for (int i = 0; i <= N; i++)
            parent[i] = i;

        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // Union
            if (question == 0) {
                union(a, b);
            }
            // FIND
            else {
                boolean result = checkSame(a, b);
                if (result)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
        sc.close();
    }

    private static void union(int a, int b) {
        // 대표 노드를 찾아서 연결
        a = find(a);
        b = find(b);
        if (a != b) {
            // 두 노드 연결
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a])
            return a;
        // 경로 압축의 로직
        return parent[a] = find(parent[a]);
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b)
            return true;
        return false;
    }
}