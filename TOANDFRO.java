import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TOANDFRO {
    static String solve(String text, int col){
        int row = text.length()/col;
        char[][] matrix = new char[row][col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = text.charAt(k++);
                }
            }else{
                for (int j = col - 1; j >= 0 ; j--) {
                    matrix[i][j] = text.charAt(k++);
                }
            }
        }
        String result = "";
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++) {
                result += matrix[j][i];
            }
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("TOANDFRO.txt"));
        Scanner scanner = new Scanner(System.in);
        while (true){
            int col = scanner.nextInt();
            if(col == 0) return;
            scanner.nextLine();
            String text = scanner.nextLine();
            System.out.println(solve(text,col));
        }
    }
}
