package ru.lachesis.lesson6;

public abstract class Animal {
    private static int count;
    protected final String name;

    public Animal(String name)
    {
        this.name=name;
        count++;
    }
    public String getName(){
        return name;
    }

    public abstract void move(int distance,String type);

    public static int getCount() {
        return count;
    }
}
