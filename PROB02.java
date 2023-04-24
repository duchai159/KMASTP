import java.util.Scanner;

public class PROB02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        for (int t = 1; t <= T; t++) {
            int M = scanner.nextInt(); 
            int N = scanner.nextInt(); 
            scanner.nextLine();
            char[][] image = new char[5 * M + 1][5 * N + 1];
            for (int i = 0; i < 5 * M + 1; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < 5 * N + 1; j++) {
                    image[i][j] = line.charAt(j); 
                }
            }
            int[] counts = new int[6]; 
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int row = 5 * i + 1; 
                    int col = 5 * j + 1; 
                    counts[getState(image, row, col)]++; 
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 5; i++) {
                System.out.print(counts[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
    public static int getState(char[][] image, int row, int col){
        if (image[row][col] == '.' ){ 
            return 0;
        } else if (image[row + 3][col] == '*') { 
            return 4;
        } else if (image[row + 2][col] == '*') { 
            return 3;
        } else if (image[row + 1][col] == '*') { 
            return 2;
        } else {
            return 1;
        }
    }
}
