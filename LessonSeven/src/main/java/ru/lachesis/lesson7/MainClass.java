package ru.lachesis.lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Василий", 100);
        Plate plate = new Plate(90);
        plate.plateInfo();
        cat1.eat(plate);
        plate.plateInfo();
        plate.increaseFood(110);
        plate.plateInfo();
        plate.decreaseFood(1500);
        plate.plateInfo();
        cat1.eat(plate);
        plate.plateInfo();
        System.out.println("=================");

        Plate bigPlate = new Plate(350);
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Кот" + (i + 1), 100);
        }
        bigPlate.plateInfo();
        System.out.println("_________________");
        catsLaunch(cats, bigPlate);
        bigPlate.plateInfo();
        bigPlate.increaseFood(150);
        bigPlate.plateInfo();
        System.out.println("_________________");
        catsLaunch(cats, bigPlate);
    }

    private static void catsLaunch(Cat[] cats, Plate plate) {
        System.out.println("Цикл кормления котов \n_________________");
        for (Cat cat : cats) {
            cat.eat(plate);
            if (cat.isSatiety()) System.out.println("Кот "+cat.getName() +" сыт."); else System.out.println("Кот "+cat.getName() +" голоден.");
            plate.plateInfo();
            System.out.println("_________________");

        }
    }
}
