import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PROB01 {
    static int n;

    private static void output(int i) {
        System.out.println("#" + i + " " + solve());
    }

    private static int calc(int n) {
        int temp;
        int sum = 0;
        while (n > 0) {
            temp = n % 10;
            sum += temp;
            n /= 10;
        }
        return sum;
    }

    private static int solve() {
        int num = calc(n);
        while (num >= 10) {
            num = calc(num);
        }
        return num;
    }

    private static void input(Scanner scanner) {
        n = scanner.nextInt();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("PROB01.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            solve();
            output(i);
        }
    }
}
