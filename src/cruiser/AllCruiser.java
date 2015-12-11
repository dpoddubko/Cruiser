package cruiser;

import java.util.SortedMap;

abstract class AllCruiser implements Cruiser {
    private int speed;
    private int lifeSum;
    private int damage;
    private String name;

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLifeSum(int lifeSum) {
        this.lifeSum = lifeSum;
    }

    public void goForward() {
        if (lifeSum > (lifeSum / 3)) {
            System.out.println("Скорость передвижения крейсера: " +
                    speed + " узлов.");
        } else {
            System.out.println("Крейсер двигаться не может");
        }
    }
    public boolean alive() { return lifeSum>0 ? true : false; }

    public void turnRight() {

    }
    public void turnLeft() {

    }

    public void attack(AllCruiser anyCruiser) {
        if (alive()){
            System.out.println("Можем атаковать!");
        }else{
            System.out.println(" Погибший крейсер не может атаковать!");
        }

    }

    public void display() {
        System.out.println(name+": ");
        System.out.println("Скорость движения: " + speed + " узлов.");
        System.out.println("Количество жизней: " + lifeSum+".");
        System.out.println("За один выстрел наносит урон " + damage + " бал(а).");
        System.out.println("");
    }
}
