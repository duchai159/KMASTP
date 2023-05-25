import java.util.Scanner;

class PROB010 {
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] robot;
    static int cnt;
    static int direct;

    static void input(Scanner scanner) {
        n = scanner.nextInt();
        robot = new int[10005][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                robot[i][j] = scanner.nextInt();
            }
        }
    }

    static int newDirect(int tx1, int ty1, int tx2, int ty2) {
        for (int i = 0; i < 4; i++) {
            if ((tx1 + dx[i]) == tx2 && (ty1 + dy[i]) == ty2) {
                return i;
            }
        }
        return -1;
    }
    static void solve() {
        cnt = 0;
        direct = newDirect(robot[0][0],robot[0][1],robot[1][0],robot[1][1]);
        int tx1 = robot[1][0];
        int ty1 = robot[1][1];
        for (int i = 2; i < n; i++) {
            int tx2 = robot[i][0];
            int ty2 = robot[i][1];
            int direct1 = newDirect(tx1, ty1, tx2, ty2);
            if ((direct + 1) % 4 == direct1) {
                cnt++;
            }
            tx1 = tx2;
            ty1 = ty2;
            direct = direct1;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            solve();
            System.out.println("#" + i + " " + cnt);
        }
    }
}
