import java.util.Scanner;

class PROB12 {
    static int x,y,k;
    static String rA, rB;
    static int directA;
    static int directB;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int xA;
    static int yA;
    static int xB;
    static int yB;
    static void input(Scanner scanner){
        x = scanner.nextInt();
        y = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        rA = scanner.nextLine();
        rB = scanner.nextLine();
    }
    static void init(){
        directA = 1;
        directB = 1;
        xA = 0;
        yA = 0;
        xB = 0;
        yB = 0;
    }
    static int newDirect(int direct, char s){
        if(s == 'W') return 0;
        if(s == 'N') return 1;
        if(s == 'E') return 2;
        if(s == 'S') return 3;
        if(s == 'L') return (direct + 3) % 4;
        if(s == 'R') return (direct + 1) % 4;
        if(s == 'B') return (direct + 2) % 4;
        return direct;
    }
    static boolean robotA(){
        for (int i = 0; i < rA.length(); i++) {
            directA = newDirect(directA, rA.charAt(i));
            xA += dx[directA];
            yA += dy[directA];
            if(xA == x && yA == y) return true;
        }
        return false;
    }
    static boolean robotB(){
        for (int i = 0; i < rB.length(); i++) {
            directB = newDirect(directB, rB.charAt(i));
            xB += dx[directB];
            yB += dy[directB];
            if(xB == x && yB == y) return true;
        }
        return false;
    }
    static void solve(int i){
        boolean robotA = robotA();
        boolean robotB = robotB();
        if(robotA && robotB){
            System.out.println("#" + i + " Good game!");
        }else if(robotA){
            System.out.println("#" + i + " Team A win");
        }else if(robotB){
            System.out.println("#" + i + " Team B win");
        }else{
            double distanceA = Math.sqrt(Math.pow((xA - x),2) + Math.pow((yA - y),2));
            double distanceB = Math.sqrt(Math.pow((xB - x),2) + Math.pow((yB - y),2));
            System.out.println("#" + i + " " + String.format("%.3f",distanceA) + " " + String.format("%.3f",distanceB));
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            input(scanner);
            init();
            solve(i);
        }
    }
}
