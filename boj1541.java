import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String exmaple = sc.nextLine();
        String[] str = exmaple.split("-");
        for (int i = 0; i < str.length; i++) {
            int tmp = mySum(str[i]);
            if (i == 0)
                answer += tmp;
            else
                answer -= tmp;
        }
        System.out.println(answer);
        sc.close();
    }

    private static int mySum(String str) {
        int sum = 0;
        // + char를 인식하지 못하는 경우 [] 를 추가해준다
        String[] tmp = str.split("[+]");
        for (int i = 0; i < tmp.length; i++)
            sum += Integer.parseInt(tmp[i]);
        return sum;
    }
}