import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ADDREV {
    static int x, y;

    static void input(Scanner scanner) {
        x = scanner.nextInt();
        y = scanner.nextInt();
    }

    static int reversed(int n) {
        int num = 0;
        while (n > 0) {
            int temp = n % 10;
            num = num * 10 + temp;
            n /= 10;
        }
        return num;
    }

    static int solve() {
        return reversed(reversed(x) + reversed(y));
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("ADDREV.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            System.out.println(solve());
        }
    }
}
