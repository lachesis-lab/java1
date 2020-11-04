package ru.lachesis.lesson7;

public class Cat {
    protected String name;
    protected int appetite;
    protected boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        String s = "Я, кот " + name + ", ";
        if (!satiety) {
            if (plate.getFood() - appetite >= 0) {
                plate.decreaseFood(appetite);
                satiety = true;
                System.out.println(s + "поел.");
            } else {
                System.out.println(s + "хотел поесть, но в тарелке только " + plate.food + " еды. Подожду, я гордый кот!");
            }
        }
        //satietyInfo();
    }

    public boolean isSatiety() {
        return satiety;
    }
}
