package ru.lachesis.lesson7;

public class Plate {
    protected int food;
    public Plate(int food)
    {
        this.food=food;
    }

    public int getFood(){
        return food;
    }
    public void setFood(int food){
        this.food=food;
    }

    public void decreaseFood(int food)
    {
        if (this.food<food){
            {
                System.out.println("Вы хотите съесть "+ food+" еды. А в тарелке ее всего "+this.food+". Нельзя забрать больше, чем есть в тарелке.");
 //               this.food=0;
            }
        } else  this.food-=food;
    }
    public void increaseFood(int food)
    {
        this.food+=food;
    }

    public void plateInfo()
    {
        System.out.println("В тарелке "+food +" еды.");
    }


}
