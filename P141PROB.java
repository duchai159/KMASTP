import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P141PROB {
    static int r, c;
    static final int MAX_SIZE = 55;
    static char[][] matrix = new char[MAX_SIZE][MAX_SIZE];
    static boolean check = true;
    static int countMax = 0;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static void input(Scanner scanner) {
        r = scanner.nextInt();
        c = scanner.nextInt();
        scanner.nextLine();
        check = true;
        for (int i = 0; i < r; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == '.') check = false;
            }
        }
    }

    static boolean outOfMatrix(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c;
    }

    static int process(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (!outOfMatrix(tx, ty) && matrix[tx][ty] == 'o') {
                count++;
            }
        }
        return count;
    }

    static int calc() {
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 'o') {
                    count += process(i, j);
                }
            }
        }
        return count / 2;
    }

    static void solve() {
        if (!check) {
            int countMax = 0;
            int temp = calc();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (matrix[i][j] == '.') {
                        int count = temp + process(i, j);
                        if (count > countMax) {
                            countMax = count;
                        }
                    }
                }
            }
            System.out.println(countMax);
        } else {
            System.out.println(calc());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("P141PROB.txt"));
        Scanner scanner = new Scanner(System.in);
        input(scanner);
        solve();
    }
}
