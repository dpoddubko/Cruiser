package cruiser;

import java.util.SortedMap;

abstract class AllCruiser implements Cruiser {
    private int speed;//скорость движения  крейсера
    private int lifeSum;//количество жизней крейсера
    private int damage;//урон, который наносит данный крейсер другому за одну атаку
    private String name;//имя крейсера

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
//движение вперед
    public void goForward() {
        if (lifeSum > (lifeSum / 3)) {
            System.out.println("Скорость передвижения крейсера: " +
                    speed + " узлов.");
        } else {
            System.out.println("Крейсер двигаться не может");
        }
    }
// проверка жив корабль или погиб
    public boolean alive() {
        if (lifeSum > 0) {
            //Крейсер живой
            return true;
        } else {
            //"Крейсер погиб!
            return false;
        }
    }
//поворот вправо
    public void turnRight() {

    }
//поворот влево
    public void turnLeft() {

    }
//
    public void attack() {
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
