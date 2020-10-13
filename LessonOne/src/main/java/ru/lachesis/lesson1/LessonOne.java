package ru.lachesis.lesson1;

public class LessonOne {
    public static void main(String[] args) {
        //2.
        byte value1 = 16;
        short value2 = 12334;
        int value3 = -10;
        long value4 = 1000L;
        float value5 = 10.2F;
        double value6 = 100 / 1.8;
        char ch = 'q';
        boolean isTrue = false;
        //3.
        printTaskNumber(3);
        float a = 4F, b = 25.1F, c = 1.5F, d = 3F;
        System.out.println("Результат calc: " + calc(a, b, c, d));
        //4.
        printTaskNumber(4);
        int x = 5;
        int y = 8;
        System.out.println("Результат between10And20: " + between10And20(x, y));
        //5.
        printTaskNumber(5);
        isPositive(value3);
        isPositive((int) value4);
        //6.
        printTaskNumber(6);
        if (isPositiveBool(0))
            System.out.println("Число положительно");
        else
            System.out.println("Число отрицательно");

        //7.
        printTaskNumber(7);
        helloName("Вася");
        //8.
        printTaskNumber(8);
        int year = 1900;
        isLeap(year);
        isLeap(1903);
        isLeap(1904);
        isLeap(1600);
        isLeap(value3);
    }

    public static float calc(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean between10And20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void isPositive(int a) {
        if (a >= 0) System.out.println("Число " + a + " положительное");
        else System.out.println("Число " + a + " отрицательное");
    }

    public static boolean isPositiveBool(int a) {
        return a >= 0;
    }
    public static void helloName(String name){
        System.out.println("Привет, " + name+"!");
    }
    public static void isLeap(int year) {
        boolean isLeap = false;
        if (year > 0) {
    /*//Вариант
        if (isLeap=year%4==0){
            if (year%100==0){
                isLeap = year%400==0;
            }
        }
    */
            isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            System.out.println("Год " + year + (isLeap ? " Високосный" : " Невисокосный"));
        } else
            System.out.println("Некорректные данные");

    }
    public static void printTaskNumber(int num)
    {
        System.out.println("Задача "+num);
    }
}
