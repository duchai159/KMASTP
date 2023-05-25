import java.util.Scanner;

public class PROB09 {
    static int n;
    static int m;
    static int[][] matrix;
    static String pac;
    static String ghost;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static final int MAX = 105;
    static int directPac;
    static int directGhost;
    static long countPac;
    static long countGhost;
    static int txPac;
    static int tyPac;
    static int txGhost;
    static int tyGhost;

    static void input(Scanner scanner) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        matrix = new int[MAX][MAX];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        pac = scanner.nextLine();
        ghost = scanner.nextLine();
        directPac = 3;
        directGhost = 1;
        countPac = 0;
        countGhost = 0;
        txPac = 0;
        tyPac = 0;
        txGhost = n - 1;
        tyGhost = n - 1;
    }
    static int newDirect(int direct, char loc){
        if(loc == 'L'){
            direct = (direct + 3) % 4;
        }
        if(loc == 'R'){
            direct = (direct + 1) % 4;
        }
        return direct;
    }
    static boolean process(){
        txPac += dx[directPac];
        tyPac += dy[directPac];
        txGhost += dx[directGhost];
        tyGhost += dy[directGhost];
        if(txPac == txGhost && tyPac == tyGhost){
            return false;
        }else{
            countPac += matrix[txPac][tyPac];
            matrix[txPac][tyPac] = 0;
            countGhost += matrix[txGhost][tyGhost];
            matrix[txGhost][tyGhost] = 0;
        }
        return true;
    }
    static void solve() {
        for (int i = 0; i < m; i++) {
            directPac = newDirect(directPac, pac.charAt(i));
            directGhost = newDirect(directGhost, ghost.charAt(i));
            if(!process()){
                break;
            }
        }
    }
    static void output(int i){
        System.out.println("#" + i + " " + countPac + " " + countGhost);

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
