import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PROB06 {
    static int m, n;
    static final int MAX_SIZE = 105;
    static char[][] matrix = new char[MAX_SIZE][MAX_SIZE];

    static void input(Scanner scanner) {
        m = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    static boolean outOfMatrix(int x, int y) {
        return x < 0 || x >= m || y < 0 || y >= n;
    }

    static void process(int x, int y, int type) {
        int[] tx = {x + 0, x - type, x + 0, x + type};
        int[] ty = {y - type, y + 0, y + type, y + 0};
        for (int i = 0; i < 4; i++) {
            if(!outOfMatrix(tx[i],ty[i]) && matrix[tx[i]][ty[i]] == 'H'){
                matrix[tx[i]][ty[i]] = 'X';
            }
        }
    }

    static void solve() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'A') {
                    process(i,j,1);
                } else if (matrix[i][j] == 'B') {
                    process(i,j,1);
                    process(i,j,2);
                } else if (matrix[i][j] == 'C') {
                    process(i,j,1);
                    process(i,j,2);
                    process(i,j,3);
                }
            }
        }
    }
    static void output(int t){
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 'H'){
                    res++;
                }
            }
        }
        System.out.println("#" + t + " " + res);
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("PROB06.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T ; i++) {
            input(scanner);
            solve();
            output(i);
        }
        scanner.close();
    }
}
