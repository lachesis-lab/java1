package ru.lachesis.lesson6;

public class Cat extends Animal {
    private static int count;
    protected String color;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
        count++;
    }

    @Override
    public void move(int distance,String type) {
        String movetype;
        String message = "Кот " + name ;
        int maxDistance = 200;
        if ("run".equals(type)) movetype=" пробежал ";
        else if ("swim".equals(type)) {
 //           movetype="проплыл ";
            System.out.println(message +", как и все коты, не умеет плавать!");
            return;
        }
        else {
            System.out.println(message +" не понял, что делать");
            return;
        }

        if (distance >= 0 && distance <= maxDistance)
            message += movetype + distance + " метров.";
        else if (distance > maxDistance)
            message += movetype + maxDistance + " метров из " +distance +" и... устал.";
        else
            message += " не понял, что ему делать";
        System.out.println(message);
    }

    public static int getCount() {
        return count;
    }


}
