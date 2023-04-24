import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P141PROB {
    static int r, c;
    static char[][] matrix = new char[r][c];
    static boolean check = true;
    static int countMax = 0;

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
    static void output() {

    }

    static boolean outOfMatrix(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c;
    }

    static int process(int x, int y) {
        int count = 0;
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (!outOfMatrix(tx,ty) && matrix[tx][ty] == 'o') {
                    count++;
            }
        }
        return count;
    }
    static void solve() {
        if(!check){
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(matrix[i][j] == 'o'){

                    }
                }
            }
        }else{
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    count += process(i,j);
                    matrix[i][j] = '.';
                }
            }
            System.out.println(count);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("P141PROB.txt"));
        Scanner scanner = new Scanner(System.in);
        input(scanner);
        solve();
        output();
    }
}
