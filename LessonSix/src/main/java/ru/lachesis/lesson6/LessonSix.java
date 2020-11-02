package ru.lachesis.lesson6;

public class LessonSix {
    public static void main(String[] args) {
        Animal animal1 = new Cat("Барсик","Рыжий");
        Cat cat1 = new Cat("Кузя","Черный");
        Dog dog1 = new Dog("Джек","Дог");
       // System.out.println(animal1.getName());
        cat1.move(100,"run");
        animal1.move(100,"swim");
        dog1.move(1000,"run");
        dog1.move(100,"swim");
        animal1.move(-10,"run");
        System.out.println("Создано экземпляров класса Animal: "+Animal.getCount());
        System.out.println("Создано экземпляров класса Cat: "+Cat.getCount());
        System.out.println("Создано экземпляров класса Dog: "+Dog.getCount());
    }
}
