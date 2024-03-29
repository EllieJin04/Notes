package javaoop.foxandrabbit.animal;

import javaoop.foxandrabbit.field.Location;

import java.util.ArrayList;


public abstract class Animal {
    private int ageLimit;
    private int breedableAge;
    private int age;
    private boolean isAlive = true;

    public Animal(int ageLimit, int breedableAge) {
        this.ageLimit = ageLimit;
        this.breedableAge = breedableAge;
    }

    protected int getAge() {
        return age;
    }

    protected double getAgePercent() {
        return (double) age / (double) ageLimit;
    }

    public abstract Animal breed();

    public void grow() {
        age++;
        if (age >= ageLimit)
            die();
    }

    public void die() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isBreedable() {
        return (age >= breedableAge);
    }

    //概率移动,移动位置
    public Location move(Location[] freeAdj) {
        Location ret = null;
        if (freeAdj.length > 0 && Math.random() < 0.02) {
            ret = freeAdj[(int) (Math.random() * freeAdj.length)];
        }
        return ret;
    }

    @Override
    public String toString() {
        return "age" + ":" + age + ", " + (isAlive ? "live" : "dead");
    }

    public Animal feed(ArrayList<Animal> neighbor) {
        return null;
    }

    protected void longerLife(int inc) {
        ageLimit += inc;
    }

}


