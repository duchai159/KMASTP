import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P141PROJ {
    static char[][] matrix = new char[4][4];
    static boolean check = false;

    static void input(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    static boolean outOfMatrix(int x, int y) {
        return x < 0 || x >= 4 || y < 0 || y >= 4;
    }

    static void process(int x, int y, char type) {
        int tx,ty;
        int count = 0;
        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
        for (int i = 0; i < 3; i++) {
            tx = x + dx[i];
            ty = y + dy[i];
            if(matrix[tx][ty] == type){
                count++;
            }
            if (count == 2){
                check = true;
                break;
            }
        }
    }

    static void solve() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(matrix[i][j] == '#'){
                    process(i,j,'#');
                }
                if (matrix[i][j] == '.'){
                    process(i,j,'.');
                }
            }
        }
    }
    static void output(){
        if (check){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("P141PROJ.txt"));
        Scanner scanner = new Scanner(System.in);
        input(scanner);
        solve();
        output();
    }
}
