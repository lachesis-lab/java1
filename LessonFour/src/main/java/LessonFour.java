import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LessonFour {
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final int DOTS_TO_BLOCK = DOTS_TO_WIN - 1;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static int[][] points = new int[SIZE][2];
    public static ArrayList<int[]> blockPoints;
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        map = new char[SIZE][SIZE];
        initMap();
        printMap();

        while (true) {
            if (humanAttempt()) break;
            if (aiAttempt()) break;
        }
    }

    private static boolean aiAttempt() {
        int[] point = new int[2];
        String message="";
        do {
            if (blockPoints.size() > 0) {
                message="А вот тебе!";
                point = blockPoints.get(rand.nextInt(blockPoints.size()));
                if (isValidPoint(point)) break;
            }

                message="Рандомный ход";
                point[0] = 1 + rand.nextInt(SIZE);
                point[1] = 1 + rand.nextInt(SIZE);

        } while (!isValidPoint(point));
        System.out.println("Ход компьютера: "+message +" " + (point[0]) + " " + (point[1]));
        addPoint(point, DOT_O);
        printMap();
        return checkMap(DOT_O, ' ');
    }

    private static boolean humanAttempt() {
        int[] point = new int[2];
        do {
            System.out.println("Введите координаты точки в формате X Y");
            point[0] = Integer.parseInt(scanner.next());
            point[1] = Integer.parseInt(scanner.next());
        } while (!isValidPoint(point));
        addPoint(point, DOT_X);
        printMap();
        return checkMap(DOT_X, DOT_X);

    }

    private static boolean checkMap(char ch, char testCh) {
        blockPoints = new ArrayList<>();
        int count = 0;
        int n = 0;
        //по горизонтали
        for (int i = 0; i < SIZE; i++) {
            initPoints(SIZE);
            for (int j = 0; j < SIZE; j++) {
                points[j][0] = i + 1;
                points[j][1] = j + 1;
                if (map[i][j] == ch) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        printWin(ch, 1);
                        return true;
                    }
                } else count = 0;
            }
            analisePoints(points, testCh);
            n++;
            count = 0;
        }
        count = 0;
        //по вертикали
        for (int i = 0; i < SIZE; i++) {
            initPoints(SIZE);
            for (int j = 0; j < SIZE; j++) {
                points[j][0] = j + 1;
                points[j][1] = i + 1;
                if (map[j][i] == ch) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        printWin(ch, 2);
                        return true;
                    }
                } else count = 0;
            }
            analisePoints(points, testCh);
            n++;
            count = 0;
        }
        count = 0;
        //вдоль гл. диагонали (ниже)+
        for (int i = SIZE - 1; i >= 0; i--) {
            initPoints(SIZE - i);
            for (int j = i; j < SIZE; j++) {
                points[j - i][0] = j + 1;
                points[j - i][1] = j - i + 1;
//                if (map[j-i][j] == ch) {
                if (map[-1 + points[j - i][0]][-1 + points[j - i][1]] == ch) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        printWin(ch, 3);
                        return true;
                    }
                } else count = 0;
            }
            analisePoints(points, testCh);
            n++;
            count = 0;
        }
        count = 0;// выше диагонали +
        for (int i = 0; i < SIZE; i++) {
            initPoints(SIZE - i);
            for (int j = i; j < SIZE; j++) {
                points[j - i][0] = j - i + 1;
                points[j - i][1] = j + 1;
//                if (map[j - i][j] == ch) {
                if (map[-1 + points[j - i][0]][-1 + points[j - i][1]] == ch) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        printWin(ch, 4);
                        return true;
                    }
                } else count = 0;
            }
            analisePoints(points, testCh);
            n++;
            count = 0;
        }
        count = 0;
        //вдоль побочной диагонали (выше)+
        for (int i = 0; i < SIZE; i++) {
            initPoints(i + 1);
            for (int j = i; j >= 0; j--) {
                points[i - j][0] = j + 1;
                points[i - j][1] = i - j + 1;
                //               if (map[j][i - j] == ch) {
                if (map[-1 + points[i - j][0]][-1 + points[i - j][1]] == ch) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        printWin(ch, 5);
                        return true;
                    }
                } else count = 0;
            }
            analisePoints(points, testCh);
            n++;
            count = 0;
        }
        count = 0;//ниже диагонали
        for (int i = 0; i < SIZE; i++) {
            initPoints(SIZE - i);
            for (int j = i; j < SIZE; j++) {
                points[j - i][0] = i - j + SIZE;
                points[j - i][1] = j + 1;
                if (map[-1 + points[j - i][0]][-1 + points[j - i][1]] == ch) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        printWin(ch, 6);
                        return true;
                    }
                } else count = 0;
            }
            count = 0;
            analisePoints(points, testCh);
            n++;
        }
/*

        System.out.println("Блоки");

        for (int i = 0; i < blockPoints.size(); i++)
                System.out.println(Arrays.toString(blockPoints.get(i)));

 */
        return false;
    }


    private static void analisePoints(int[][] points, char ch) {
        int[] point = new int[2];
        int filled = 0;
        int unfilled = 0;
        int totalFilled = 0;
        for (int i = 0; i < points.length; i++) {
            if (points.length < DOTS_TO_WIN) break;
            if (map[-1 + points[i][0]][-1 + points[i][1]] == ch) {
                if (filled < totalFilled && totalFilled == DOTS_TO_BLOCK) break;
                filled++;
                totalFilled++;
                unfilled = 0;
            } else  {
                if (filled == DOTS_TO_BLOCK) {
                    if (point[0] == 0) point = points[i];
                    break;
                }
                if (filled < DOTS_TO_BLOCK) {
                    if (point[0] == 0) point = points[i];
                    filled = 0;
                    if (unfilled == 0) unfilled++;
                    else {
                        return;
                    }
                }
            }
        }
        if (point[0] != 0)
            blockPoints.add(point);
//        return;

    }

    private static void initPoints(int n) {
        points = new int[n][2];
    }

    private static void printWin(char ch, int n) {
        System.out.println("Ура! Выиграли " + ch + "!");
    }
/*

    private static int[][] nearPoints(int[] point, char ch) {
        int[][] result = new int[8][2];
        int minX, maxX, minY, maxY;
        minX = point[0] == 1 ? point[0] : (point[0] - 1);
        maxX = point[0] == SIZE ? point[0] : (point[0] + 1);
        minY = point[1] == 1 ? point[1] : (point[1] - 1);
        maxY = point[1] == SIZE ? point[1] : (point[1] + 1);
        int k = 0;
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (x == point[0] && y == point[1]) continue;
                if (map[x - 1][y - 1] == ch) {
                    result[k][0] = x;
                    result[k][1] = y;
                }
                k++;
            }
        }
        return result;
    }

    private static boolean isPointAtPoint(int[] firstPoint, int[] nextPoint) {
        return !Arrays.equals(firstPoint, nextPoint) && firstPoint[0] > 0 && Math.abs(firstPoint[0] - nextPoint[0]) <= 1 && Math.abs(firstPoint[1] - nextPoint[1]) <= 1;
    }
*/

    private static boolean isValidPoint(int[] point) {
        return point[0] > 0 && point[0] <= SIZE && point[1] > 0 && point[1] <= SIZE && map[point[0] - 1][point[1] - 1] == DOT_EMPTY;
    }

    private static void addPoint(int[] newUserPoint, char dot) {
        map[newUserPoint[0] - 1][newUserPoint[1] - 1] = dot;
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    private static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print((j == 0 ? Integer.toString(i + 1) : "") + " " + map[i][j]);
            }
            System.out.println();
        }
    }
/*

    private static int min(int a, int b) {
        int min = a;
        if (b < a) min = b;
        return min;
    }
    private static int max(int a, int b) {
        int max=a;
        if (b>a) max = b;
        return max;
    }
*/

}
