import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PROB04 {
    static int r, c;
    static int a[][];

    static void input(Scanner scanner) {
        r = scanner.nextInt();
        c = scanner.nextInt();
        scanner.nextLine();
        a = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < c; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
    }
    static int solve() {
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        Arrays.fill(row, true);
        Arrays.fill(col, true);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 1) {
                    row[i] = false;
                    col[j] = false;
                }
            }
        }
        int countRow = 0;
        int countCol = 0;
        for (boolean value : row) {
            if (value) countRow++;
        }
        for (boolean value : col) {
            if (value) countCol++;
        }
        return (countRow * c) + (r - countRow)*countCol;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("PROB04.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            System.out.println("#" + i + " " + solve());
        }
        scanner.close();
    }
}
