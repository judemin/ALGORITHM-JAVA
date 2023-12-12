import java.util.Scanner;

// 투포인터를 통해 O(n)의 시간복잡도를 가질 수 있도록
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1, start_index = 1, end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
        sc.close();
    }
}