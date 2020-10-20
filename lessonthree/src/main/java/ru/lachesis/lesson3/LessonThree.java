package ru.lachesis.lesson3;

import java.util.Random;
import java.util.Scanner;

public class LessonThree {
    final public static Random random = new Random();
    final public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordNum;
        String yn;
        String userWord;
        boolean isContinue=true;
        System.out.println("Начинаем игру. Для выхода введите \"end\"");
        wordNum = random.nextInt(words.length);
        System.out.println("Слово загадано");
 //       System.out.println(words[wordNum]);
        while (isContinue) {
            System.out.println("\nВведите Ваш вариант ответа:");
            userWord = scanner.nextLine();
            if ("end".equalsIgnoreCase(userWord)) {
                System.out.println("Игра закончена");
                isContinue =false;
            } else {
                if (checkWord(userWord, words[wordNum])) {
                    while(true) {
                        System.out.println("Хотите продолжить игру? Введите \"yes\" или \"no\"");
                        yn = scanner.nextLine();
                        if ("yes".equalsIgnoreCase(yn)) {
                            wordNum = random.nextInt(words.length);
                            System.out.println("Новое слово загадано");
//                          System.out.println(words[wordNum]);
                            break;
                        } else if("no".equalsIgnoreCase(yn)) {
                            System.out.println("Игра закончена");
                            isContinue=false;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean checkWord(String userWord, String word) {
        if (word.equalsIgnoreCase(userWord)) {
            System.out.println("Вы выиграли!");
            return true;
        }
        for (int i = 0; i < 15; i++) {
            if (i < min(userWord.length(), word.length())) {
                if (userWord.toLowerCase().charAt(i) == word.charAt(i))
                    System.out.print(userWord.toLowerCase().charAt(i));
                else System.out.print("#");
            } else System.out.print("#");
        }
        return false;
    }

    private static int min(int x, int y) {
        int min = x;
        if (y < x) min = y;
        return min;
    }
}
