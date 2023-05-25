import java.util.Scanner;

class PROB15 {
    static int n;
    static int[][] bridge;
    static String road;
    static final int MAX = 1005;
    static int[] dx = {-1, -1, -1};
    static int[] dy = {0, -1, 1};
    static int marioX;
    static int marioY;
    static int cntCoin;
    static int direct;

    static void input(Scanner scanner) {
        n = scanner.nextInt();
        bridge = new int[MAX][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                bridge[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        road = scanner.nextLine();
    }
    static boolean process(int direct){
        marioX += dx[direct];
        marioY += dy[direct];
        if(bridge[marioX][marioY] == 2){
            return false;
        }else if(bridge[marioX][marioY] == 1){
            cntCoin++;
        }
        return true;
    }
    static void solve(int T){
        marioX = n;
        marioY = 2;
        cntCoin = 0;
        for (int i = 0; i < road.length(); i++) {
            char temp = road.charAt(i);
            if(temp == 'C') direct = 0;
            if(temp == 'L') direct = 1;
            if(temp == 'R') direct = 2;
            if(!process(direct)){
                System.out.print("#" + T + " NO");
                return;
            }
        }
        System.out.print("#" + T + " YES " + cntCoin);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            solve(i);
            System.out.println();
        }
    }
}
