package ru.lachesis.lesson6;

public class Dog extends Animal{
    private static int count;
    protected String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
        count++;
    }

    @Override
    public void move(int distance,String type) {
        String movetype;
        int maxDistance;
        if ("run".equals(type))
        {
            maxDistance = 500;
            movetype="пробежал ";
        }
        else if ("swim".equals(type)) {
            movetype="проплыл ";
            maxDistance = 10;
        }
        else {
            System.out.println("Не понял, что делать");
            return;
        }
        String message = "Пес " + name + " ";

        if (distance >= 0 && distance <= maxDistance)
            message += movetype + distance + " метров.";
        else if (distance > maxDistance)
            message += movetype + maxDistance + " метров из " +distance +" и... устал.";
        else
            message += "не понял, что делать";
        System.out.println(message);
    }


    public static int getCount()    {return count;}

}
