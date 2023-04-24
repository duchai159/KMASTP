
import java.util.Scanner;

public class PROB03 {
    static int h,w,m,n;
    static int[][] a;
    static void input(Scanner scanner){
        h = scanner.nextInt();
        w = scanner.nextInt();
        m = scanner.nextInt();
        n = scanner.nextInt();
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
    }
    
    static int solve(){
        int max_i = m - h;
        int max_j = n - w;
        int res = 0;
        for (int i = 0; i <= max_i; i++) {
            for (int j = 0; j <= max_j; j++) {
                if(res < calc(i,j)){
                    res = calc(i, j);
                }
            }
        }
        return res;
    }
    static int calc(int start_row, int start_col){
        int sum = 0;
        //duyet canh
        for (int j = start_col; j < start_col + w; j++) {
            //dong dau tien
            if(a[start_row][j] % 2 == 0){
                sum += a[start_row][j];
            }
            //dong cuoi cung
            if(a[start_row + h -1][j] % 2 == 0){
                sum += a[start_row + h -1][j];
            }
        }
        //duyet cot
        for (int i = start_row + 1; i < start_row + h - 1; i++) {
            //canh trai
            if(a[i][start_col] % 2 == 0){
                sum += a[i][start_col];
            }
            //canh phai
            if(a[i][start_col + w - 1] % 2 == 0){
                sum += a[i][start_col + w - 1];
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            System.out.println("#" + i + " " + solve());
        }
    }
}
