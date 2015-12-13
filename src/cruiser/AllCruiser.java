package cruiser;

import java.util.SortedMap;

public abstract class AllCruiser implements Cruiser {
    final private int SPEED;
    final private int INITIALLIFE;
    final private int DAMAGE;
    final private String NAME;
    private int lifeSum;

    public AllCruiser(int speed, int initialLife, String name, int damage) {
        this.SPEED = speed;
        this.INITIALLIFE = initialLife;
        this.lifeSum = initialLife;
        this.NAME = name;
        this.DAMAGE = damage;
    }

    public void log(String msg) {
        System.out.println(msg);
    }

    public void goForward() {
        if (lifeSum > (INITIALLIFE / 3)) {
            log("Скорость передвижения крейсера: " +
                    SPEED + " узлов.");
        } else {
            log("Крейсер двигаться не может");
        }
    }

    public boolean alive() {
        return lifeSum > 0;
    }

    public void turnRight() {

    }

    public void turnLeft() {

    }

   // @Override
    public void attack(AllCruiser anyCruiser) {
        if (alive()) {
anyCruiser.lifeSum--;
           log("lifeSum "+anyCruiser.lifeSum);
           log("initialLife "+anyCruiser.INITIALLIFE);

        }
    }

    public void display() {
        log(NAME + ": ");
        log("Скорость движения: " + SPEED + " узлов.");
        log("Начальное количество жизней: " + INITIALLIFE + ".");
        log("Оставшееся количество жизней: " + lifeSum + ".");
        log("За один выстрел наносит урон " + DAMAGE + " бал(а).");
        log("");
    }
}
