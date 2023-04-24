import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PROB07 {
    static int row, col;
    static int MAX_SIZE = 205;
    static char[][] matrix = new char[MAX_SIZE][MAX_SIZE];
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("PROB07.txt"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            System.out.println("Case #" + i +": " + solve());
        }
    }

    private static int process(int x, int y){
        int count = 0;
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (!outOfMatrix(tx,ty) && matrix[tx][ty] == '*') {
                count++;
            }
        }
        return count;
    }

    private static boolean outOfMatrix(int x, int y) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    private static int solve() {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '.'){
                    count += process(i,j);
                }
            }
        }
        return count;
    }

    private static void input(Scanner scanner) {
        row = scanner.nextInt();
        col = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < row; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }
}
