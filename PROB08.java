import java.util.Scanner;

public class PROB08 {
    static int n, k, m, d;
    static int[][] board;
    static int[] chess;
    static int knightX;
    static int knightY;
    static int countMax;

    static void input(Scanner scanner) {
        n = scanner.nextInt();
        k = scanner.nextInt();
        m = scanner.nextInt();
        d = scanner.nextInt();
        chess = new int[2 * k];
        board = new int[1005][1005];
        for (int i = 0; i < 2 * k; i++) {
            chess[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board[x][y] = 1;
        }
        for (int i = 0; i < d; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board[x][y] = 0;
        }
    }

    static boolean outOfMatrix(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    static int process(int x, int y) {
        int count = 0;
        int[] tx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] ty = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < 8; i++) {
            int dx = x + tx[i];
            int dy = y + ty[i];
            if (!outOfMatrix(dx, dy) && board[dx][dy] == 1) {
                count++;
            }
        }
        return count;
    }

    static void solve() {
        for (int i = 0; i < chess.length; i+=2) {
            board[chess[i]][chess[i+1]] = 1;
        }
        countMax = -1;
        for (int i = 0; i < chess.length; i += 2) {
            int x = chess[i];
            int y = chess[i + 1];
            int count = process(x, y);
            if (count > countMax) {
                countMax = count;
                knightX = x;
                knightY = y;
            }
        }
    }

    static void output(int t) {
        System.out.println("#" + t + " " + knightX + " " + knightY + " " + countMax);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            solve();
            output(i);
        }
    }
}
