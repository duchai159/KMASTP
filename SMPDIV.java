import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SMPDIV {
    static int n, x, y;

    static void input(Scanner scanner) {
        n = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
    }

    static void solve() {
        for (int i = x; i < n; i += x) {
            if (i % x == 0 && i % y != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("SMPDIV.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            solve();
        }
    }
}
