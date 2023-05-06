import java.util.Scanner;

public class QKP {
    static int m, n;
    static int[][] board;
    static int[] queen;
    static int[] knight;
    static int[] txK = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] tyK = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dxQ = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dyQ = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int count;
    static final int MAX_SIZE = 1005;
    static int index = 0;

    static void input(Scanner scanner) {
        m = scanner.nextInt();
        n = scanner.nextInt();
        if (m != 0 && n != 0) {
            board = new int[MAX_SIZE][MAX_SIZE];
            count = m * n;
            for (int i = 0; i < 3; i++) {
                int k = scanner.nextInt();
                if (i == 0) queen = new int[2 * k];
                if (i == 1) knight = new int[2 * k];
                count -= k;
                for (int j = 0; j < k; j++) {
                    int x = scanner.nextInt() - 1;
                    int y = scanner.nextInt() - 1;
                    if (i == 0) {
                        board[x][y] = 1;
                        queen[2 * j] = x;
                        queen[2 * j + 1] = y;
                    } else if (i == 1) {
                        board[x][y] = 1;
                        knight[2 * j] = x;
                        knight[2 * j + 1] = y;
                    } else {
                        board[x][y] = 1;
                    }
                }
            }
        }
        index++;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    static void markK(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int tx = txK[i] + x;
            int ty = tyK[i] + y;
            if (isValid(tx, ty) && board[tx][ty] == 0) {
                count--;
                board[tx][ty] = 2;
            }
        }
    }

    static void markQ(int x, int y, int direct) {
        int tx, ty, t = 1;
        while (true) {
            tx = x + dxQ[direct] * t;
            ty = y + dyQ[direct] * t;
            if (isValid(tx, ty) && board[tx][ty] == 0) {
                count--;
                board[tx][ty] = 2;
            } else if (!isValid(tx,ty) || board[tx][ty] == 1) {
                break;
            }
            t++;
        }
    }

    static void solve() {
        for (int i = 0; i < knight.length; i += 2) {
            markK(knight[i], knight[i + 1]);
        }
        for (int i = 0; i < queen.length; i += 2) {
            for (int j = 0; j < 8; j++) {
                markQ(queen[i], queen[i + 1], j);
            }
        }
    }

    static void output(int index) {
        System.out.println("Board " + index + " has " + count + " safe squares.");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        m = 1;
        n = 1;
        while (m != 0 && n != 0) {
            input(scanner);
            solve();
            if (m != 0 && n != 0) {
                output(index);
            }
        }
    }
}
